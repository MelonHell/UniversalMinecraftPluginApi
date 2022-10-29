package ru.melonhell.umpa.bukkit

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.events.PacketEvent
import com.comphenix.protocol.utility.MinecraftVersion
import com.github.matfax.klassindex.KlassIndex
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.server.PluginDisableEvent
import org.bukkit.plugin.java.JavaPlugin
import ru.melonhell.umpa.bukkit.converter.PacketConverter
import ru.melonhell.umpa.bukkit.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.event.BukkitPacketEvent
import ru.melonhell.umpa.bukkit.exceptions.UmpaConverterNotFoundException
import ru.melonhell.umpa.bukkit.wrappers.BukkitPlugin
import ru.melonhell.umpa.bukkit.wrappers.BukkitUmpaPlayer
import ru.melonhell.umpa.core.event.PacketListener
import ru.melonhell.umpa.core.managers.UmpaPacketManager
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.wrappers.UmpaPlayer
import kotlin.reflect.KClass

class BukkitUmpaPacketManager(javaPlugin: JavaPlugin) : UmpaPacketManager, Listener {

    private val converterMapByWrapper: MutableMap<KClass<out UmpaPacket>, PacketConverter> =
        HashMap()
    private val converterMapByProtocolLibType: MutableMap<PacketType, PacketConverter> = HashMap()

    private val listeners = HashSet<PacketListener>()

    init {
        val converterClasses = KlassIndex.getAnnotated(ProtocolVersion::class)
        converterClasses.forEach { clazz ->
            val annotation = clazz.java.getAnnotation(ProtocolVersion::class.java)
            val minVersion = MinecraftVersion(annotation.minVersion)
            val maxVersion = MinecraftVersion(annotation.maxVersion.replace("latest", "1.99"))
            if (MinecraftVersion.getCurrentVersion() in minVersion..maxVersion) {
                val packetConverter = clazz.java.getConstructor().newInstance() as PacketConverter
                converterMapByWrapper[packetConverter.wrapperType] = packetConverter
                packetConverter.protocolLibTypes.forEach { type ->
                    converterMapByProtocolLibType[type] = packetConverter
                }
            }
        }

        ProtocolLibrary.getProtocolManager()
            .addPacketListener(object : PacketAdapter(javaPlugin, PacketType.values().filter { it.isSupported }) {
                override fun onPacketReceiving(event: PacketEvent) {
                    onPacket(event, false)
                }

                override fun onPacketSending(event: PacketEvent) {
                    onPacket(event, true)
                }
            })

        Bukkit.getPluginManager().registerEvents(this, javaPlugin)
    }

    fun wrap(packetContainer: PacketContainer): UmpaPacket {
        val packetConverter = converterMapByProtocolLibType[packetContainer.type] ?: throw UmpaConverterNotFoundException(
            packetContainer.type
        )
        return packetConverter.wrap(packetContainer)
    }

    fun unwrap(packetWrapper: UmpaPacket): List<PacketContainer> {
        val packetConverter =
            converterMapByWrapper[packetWrapper::class] ?: throw UmpaConverterNotFoundException(packetWrapper)
        return packetConverter.unwrap(packetWrapper)
    }

    override fun send(
        player: UmpaPlayer,
        packetWrapper: UmpaPacket
    ) {
        if (player !is BukkitUmpaPlayer) return
        unwrap(packetWrapper).forEach {
            ProtocolLibrary.getProtocolManager().sendServerPacket(player.player, it)
        }
    }

    override fun addListener(listener: PacketListener) {
        listeners.add(listener)
    }

    override fun removeListener(listener: PacketListener) {
        listeners.remove(listener)
    }

    private fun onPacket(event: PacketEvent, send: Boolean) {
        val packetConverter = converterMapByProtocolLibType[event.packetType] ?: return
        val bukkitPacketReceiveEvent = BukkitPacketEvent(
            event.player,
            { packetConverter.wrap(event.packet) },
            packetConverter.wrapperType.java
        )
        listeners.forEach {
            if (send) it.onPacketSending(bukkitPacketReceiveEvent)
            else it.onPacketReceiving(bukkitPacketReceiveEvent)
        }
        if (bukkitPacketReceiveEvent.canceled) {
            event.isCancelled = true
            return
        }
        if (bukkitPacketReceiveEvent.edited) {
            val unwrap = unwrap(bukkitPacketReceiveEvent.packetWrapper)
            if (unwrap.size == 1) {
                event.packet = unwrap[0]
            } else {
                // Костыль для всякой хуйни по типу ремува энтити в 1.17.0
                event.isCancelled = true
                unwrap.forEach { ProtocolLibrary.getProtocolManager().sendServerPacket(event.player, it) }
            }
        }
    }

    @EventHandler
    fun onPluginDisable(event: PluginDisableEvent) {
        listeners.removeIf { (it.pluginWrapper as BukkitPlugin).javaPlugin == event.plugin }
    }
}
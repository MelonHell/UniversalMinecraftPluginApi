package ru.melonhell.packetframework.bukkit

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
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.event.BukkitPacketEvent
import ru.melonhell.packetframework.bukkit.exceptions.ConverterNotFoundException
import ru.melonhell.packetframework.bukkit.wrappers.BukkitClient
import ru.melonhell.packetframework.bukkit.wrappers.BukkitPlugin
import ru.melonhell.packetframework.core.PacketFrameworkService
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.event.PacketListener
import ru.melonhell.packetframework.core.wrappers.Client
import kotlin.reflect.KClass

class BukkitPacketFrameworkService(javaPlugin: JavaPlugin) : PacketFrameworkService, Listener {

    private val converterMapByWrapper: MutableMap<KClass<out PacketWrapper>, PacketConverter> = HashMap()
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

    fun wrap(packetContainer: PacketContainer): PacketWrapper {
        val packetConverter = converterMapByProtocolLibType[packetContainer.type] ?: throw ConverterNotFoundException(
            packetContainer.type
        )
        return packetConverter.wrap(packetContainer)
    }

    fun unwrap(packetWrapper: PacketWrapper): List<PacketContainer> {
        val packetConverter =
            converterMapByWrapper[packetWrapper::class] ?: throw ConverterNotFoundException(packetWrapper)
        return packetConverter.unwrap(packetWrapper)
    }

    override fun send(player: Client, packetWrapper: PacketWrapper) {
        if (player !is BukkitClient) return
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
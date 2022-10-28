package ru.melonhell.packetframework.bukkit

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.events.PacketEvent
import com.comphenix.protocol.utility.MinecraftVersion
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.server.PluginDisableEvent
import org.bukkit.plugin.java.JavaPlugin
import org.reflections.Reflections
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
    private val packetTypeMap: MutableMap<PacketType, KClass<out PacketWrapper>> = HashMap()

    private val listeners = HashSet<PacketListener>()

    init {
        val reflections = Reflections("ru.melonhell.packetframework.bukkit.converter")

        val currentVersion = MinecraftVersion.getCurrentVersion()
        for (clazz in reflections.getTypesAnnotatedWith(ProtocolVersion::class.java)) {
            val annotation = clazz.getAnnotation(ProtocolVersion::class.java)
            if (currentVersion >= MinecraftVersion(annotation.minVersion) &&
                (annotation.maxVersion == "latest" || currentVersion <= MinecraftVersion(annotation.maxVersion))
            ) {
                val packetConverter = clazz.getConstructor().newInstance() as PacketConverter
                converterMapByWrapper[annotation.wrapper] = packetConverter
                packetConverter.wrapTypes
                    .forEach {
                        converterMapByProtocolLibType[it] = packetConverter
                        packetTypeMap[it] = annotation.wrapper
                    }
            }
        }

        ProtocolLibrary.getProtocolManager().addPacketListener(object : PacketAdapter(javaPlugin, PacketType.values().filter { it.isSupported }) {
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
        val packetType = packetTypeMap[event.packetType] ?: return
        val bukkitPacketReceiveEvent =
            BukkitPacketEvent(BukkitClient(event.player), event.packet, packetType.java, packetConverter)
        listeners.forEach {
            if (send) it.onPacketSending(bukkitPacketReceiveEvent) else it.onPacketReceiving(
                bukkitPacketReceiveEvent
            )
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
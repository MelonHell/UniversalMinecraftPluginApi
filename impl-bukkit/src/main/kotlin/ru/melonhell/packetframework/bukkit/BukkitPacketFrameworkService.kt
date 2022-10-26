package ru.melonhell.packetframework.bukkit

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.events.PacketEvent
import com.comphenix.protocol.utility.MinecraftVersion
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.greenrobot.eventbus.EventBus
import org.reflections.Reflections
import ru.melonhell.packetframework.core.PacketFrameworkService
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.clientbound.teleportEntity.TeleportEntityPacketConverter_v1_9_0
import ru.melonhell.packetframework.bukkit.event.BukkitPacketEvent
import ru.melonhell.packetframework.core.event.PacketFrameworkListener
import ru.melonhell.packetframework.core.protocol.game.ClientboundTeleportEntityPacketWrapper
import ru.melonhell.packetframework.core.wrappers.PlayerWrapper
import kotlin.reflect.KClass

class BukkitPacketFrameworkService(javaPlugin: JavaPlugin) : PacketFrameworkService {

    private val converterMapByWrapper: MutableMap<KClass<out PacketWrapper>, PacketConverter> = HashMap()
    private val converterMapByProtocolLibType: MutableMap<PacketType, PacketConverter> = HashMap()

    init {
        val reflections = Reflections("ru.melonhell.packetframework.bukkit.converter")

        val currentVersion = MinecraftVersion.getCurrentVersion()
        for (clazz in reflections.getTypesAnnotatedWith(ProtocolVersion::class.java)) {
            Bukkit.broadcastMessage("1" + clazz.name)
            val annotation = clazz.getAnnotation(ProtocolVersion::class.java)
            if (currentVersion >= MinecraftVersion(annotation.minVersion) &&
                (annotation.maxVersion == "latest" || currentVersion <= MinecraftVersion(annotation.maxVersion))
            ) {
                Bukkit.broadcastMessage("2" + clazz.name)
                val packetConverter = clazz.getConstructor().newInstance() as PacketConverter
                converterMapByWrapper[annotation.wrapper] = packetConverter
                packetConverter.getWrapTypes().forEach { packetType -> converterMapByProtocolLibType[packetType] = packetConverter }
            }
        }

        Bukkit.broadcastMessage("list1: ")
        converterMapByWrapper.forEach { (t, u) -> Bukkit.broadcastMessage("$t $u") }
        Bukkit.broadcastMessage("list2: ")
        converterMapByProtocolLibType.forEach { (t, u) -> Bukkit.broadcastMessage("$t $u") }

        ProtocolLibrary.getProtocolManager().addPacketListener(object : PacketAdapter(javaPlugin, PacketType.values()) {
            override fun onPacketReceiving(event: PacketEvent) {
                onPacket(event)
            }

            override fun onPacketSending(event: PacketEvent) {
                onPacket(event)
            }
        })
    }

    fun wrap(packetContainer: PacketContainer): PacketWrapper {
        val packetConverter = converterMapByProtocolLibType[packetContainer.type] ?: throw RuntimeException("сука блять нахуй")
        return packetConverter.wrap(packetContainer)
    }

    fun unwrap(packetWrapper: PacketWrapper): PacketContainer {
        val packetConverter = converterMapByWrapper[packetWrapper::class] ?: throw RuntimeException("сука блять нахуй")
        return packetConverter.unwrap(packetWrapper)
    }

    override fun send(player: PlayerWrapper, packetWrapper: PacketWrapper) {
        if (player !is BukkitPlayerWrapper) return
        if (packetWrapper is ClientboundTeleportEntityPacketWrapper) {
            val unwrap = TeleportEntityPacketConverter_v1_9_0().unwrap(packetWrapper)
            ProtocolLibrary.getProtocolManager().sendServerPacket(player.player, unwrap)
        }
    }

    override fun addListener(listener: PacketFrameworkListener) {
        EventBus.getDefault().register(listener)
    }

    override fun removeListener(listener: PacketFrameworkListener) {
        EventBus.getDefault().unregister(listener)
    }

    private fun onPacket(event: PacketEvent) {
        if (event.packetType !in converterMapByProtocolLibType.keys) return
        val bukkitPacketReceiveEvent = BukkitPacketEvent(event.packet, this)
        EventBus.getDefault().post(bukkitPacketReceiveEvent)
        if (bukkitPacketReceiveEvent.canceled) {
            event.isCancelled = true
            return
        }
        if (bukkitPacketReceiveEvent.isEdited()) {
            event.packet = unwrap(bukkitPacketReceiveEvent.getPacketWrapper())
        }
    }
}
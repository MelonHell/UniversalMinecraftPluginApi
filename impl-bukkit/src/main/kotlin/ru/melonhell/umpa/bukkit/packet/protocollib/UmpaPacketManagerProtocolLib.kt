package ru.melonhell.umpa.bukkit.packet.protocollib

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.events.PacketEvent
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import ru.melonhell.umpa.bukkit.event.UmpaPacketEventBukkit
import ru.melonhell.umpa.bukkit.exceptions.UmpaConverterNotFoundException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.bukkit.utils.MinMaxVersionUtils.isCurrentVersionInRange
import ru.melonhell.umpa.bukkit.utils.ScanUtils
import ru.melonhell.umpa.bukkit.wrappers.UmpaPlayerBukkit
import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.event.UmpaEventManager
import ru.melonhell.umpa.core.managers.UmpaPacketManager
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.wrappers.UmpaPlayer
import java.util.*

class UmpaPacketManagerProtocolLib(
    plugin: Plugin,
    private val eventManager: UmpaEventManager
) : UmpaPacketManager, Listener {

    private val converterMapByWrapper: MutableMap<UmpaPacketType, PacketConverter> = EnumMap(UmpaPacketType::class.java)
    private val converterMapByProtocolLibType: MutableMap<PacketType, PacketConverter> = HashMap()

    init {
        val converterClasses = ScanUtils.scanWithAnnotation(
            "ru.melonhell.umpa.bukkit.packet.protocollib.converter",
            MinMaxMinecraftVersion::class.java
        )
        converterClasses.forEach { clazz ->
            if (PacketConverter::class.java.isAssignableFrom(clazz)) {
                val annotation = clazz.getAnnotation(MinMaxMinecraftVersion::class.java)
                if (annotation.isCurrentVersionInRange()) {
                    val packetConverter = clazz.getConstructor().newInstance() as PacketConverter
                    converterMapByWrapper[packetConverter.packetType] = packetConverter
                    packetConverter.protocolLibTypes.forEach { type ->
                        converterMapByProtocolLibType[type] = packetConverter
                    }
                }
            }
        }

        ProtocolLibrary.getProtocolManager()
            .addPacketListener(object : PacketAdapter(plugin, PacketType.values().filter { it.isSupported }) {
                override fun onPacketReceiving(event: PacketEvent) = onPacket(event)
                override fun onPacketSending(event: PacketEvent) = onPacket(event)
            })
    }

    fun wrap(packetContainer: PacketContainer): UmpaPacket {
        val packetConverter = converterMapByProtocolLibType[packetContainer.type]
            ?: throw UmpaConverterNotFoundException(packetContainer.type)
        return packetConverter.wrap(packetContainer)
    }

    fun unwrap(packetWrapper: UmpaPacket): List<PacketContainer> {
        val packetConverter =
            converterMapByWrapper[packetWrapper.packetType] ?: throw UmpaConverterNotFoundException(packetWrapper)
        return packetConverter.unwrap(packetWrapper)
    }

    override fun send(
        player: UmpaPlayer, packetWrapper: UmpaPacket
    ) {
        if (player !is UmpaPlayerBukkit) return
        unwrap(packetWrapper).forEach {
            ProtocolLibrary.getProtocolManager().sendServerPacket(player.handle, it)
        }
    }

    private fun onPacket(protocolLibEvent: PacketEvent) {
        val packetConverter = converterMapByProtocolLibType[protocolLibEvent.packetType] ?: return
        val packetEvent = UmpaPacketEventBukkit(
            protocolLibEvent.player, lazy { packetConverter.wrap(protocolLibEvent.packet) }, packetConverter.packetType
        )
        eventManager.call(packetEvent)
        if (packetEvent.canceled) {
            protocolLibEvent.isCancelled = true
            return
        }
        if (packetEvent.edited) {
            val packetWrapper = packetEvent.packetWrapper
            if (packetWrapper.packetType.direction != packetConverter.packetType.direction)
                throw RuntimeException("ты чё долбоёб блять, ты сука клиентский пакет серверу хуяришь или наоборот я хуй знает что ты там задумал, мудоёб ебливый")
            val unwrap = unwrap(packetWrapper)
            if (unwrap.size == 1) {
                protocolLibEvent.packet = unwrap[0]
            } else {
                // Костыль для всякой хуйни по типу ремува энтити в 1.17.0
                protocolLibEvent.isCancelled = true
                unwrap.forEach { ProtocolLibrary.getProtocolManager().sendServerPacket(protocolLibEvent.player, it) }
            }
        }
    }
}
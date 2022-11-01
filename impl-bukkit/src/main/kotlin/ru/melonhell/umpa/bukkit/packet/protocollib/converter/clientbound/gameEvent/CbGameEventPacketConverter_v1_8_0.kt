package ru.melonhell.umpa.bukkit.packet.protocollib.converter.clientbound.gameEvent

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.bukkit.utils.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbGameEventPacket

@MinMaxMinecraftVersion("1.8", "latest")
class CbGameEventPacketConverter_v1_8_0 : PacketConverter {
    private val gameEvents = UmpaCbGameEventPacket.GameEvent.values()
    override fun wrap(container: PacketContainer): UmpaCbGameEventPacket {
        val gameStateId = container.gameStateIDs.read(0)
        val value = container.float.read(0)
        return UmpaCbGameEventPacket(gameEvents[gameStateId], value)
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaCbGameEventPacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.GAME_STATE_CHANGE)
        container.gameStateIDs.write(0, wrapper.gameEvent.ordinal)
        container.float.write(0, wrapper.value)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.GAME_STATE_CHANGE)
    override val packetType = UmpaPacketType.CB_GAME_EVENT
}
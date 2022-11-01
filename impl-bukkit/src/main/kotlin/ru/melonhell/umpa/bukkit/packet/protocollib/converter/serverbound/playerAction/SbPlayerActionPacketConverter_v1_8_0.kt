package ru.melonhell.umpa.bukkit.packet.protocollib.converter.serverbound.playerAction

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.bukkit.utils.MinMaxMinecraftVersion
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibEnumConverter.protocolLib
import ru.melonhell.umpa.bukkit.utils.converter.ProtocolLibEnumConverter.umpa
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.serverbound.UmpaSbPlayerActionPacket

@MinMaxMinecraftVersion("1.8", "latest")
class SbPlayerActionPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaSbPlayerActionPacket {
        val playerId = container.integers.read(0)
        val playerAction = container.playerActions.read(0).umpa()
        val data = container.integers.read(1)
        return UmpaSbPlayerActionPacket(playerId, playerAction, data)
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaSbPlayerActionPacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Client.ENTITY_ACTION)
        container.integers.write(0, wrapper.playerId)
        container.playerActions.write(0, wrapper.action.protocolLib())
        container.integers.write(1, wrapper.data)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Client.ENTITY_ACTION)
    override val packetType = UmpaPacketType.SB_PLAYER_ACTION
}
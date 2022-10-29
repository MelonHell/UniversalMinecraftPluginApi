package ru.melonhell.umpa.bukkit.converter.serverbound.playerAction

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.wrappers.EnumWrappers
import ru.melonhell.umpa.bukkit.converter.PacketConverter
import ru.melonhell.umpa.bukkit.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.serverbound.UmpaSbPlayerActionPacket

@ProtocolVersion("1.8", "latest")
class SbPlayerActionPacketConverter_v1_8_0 : PacketConverter {

    private val playerCommandActions = UmpaSbPlayerActionPacket.PlayerAction.values()
    private val playerActionsProtocolLib = EnumWrappers.PlayerAction.values()

    override fun wrap(container: PacketContainer): UmpaSbPlayerActionPacket {
        val playerId = container.integers.read(0)
        val playerAction = container.playerActions.read(0)
        val data = container.integers.read(1)
        return UmpaSbPlayerActionPacket(playerId, playerCommandActions[playerAction.ordinal], data)
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaSbPlayerActionPacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Client.ENTITY_ACTION)
        container.integers.write(0, wrapper.playerId)
        container.playerActions.write(0, playerActionsProtocolLib[wrapper.action.ordinal])
        container.integers.write(1, wrapper.data)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Client.ENTITY_ACTION)
    override val wrapperType = UmpaSbPlayerActionPacket::class
}
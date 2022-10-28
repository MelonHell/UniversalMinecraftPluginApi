package ru.melonhell.packetframework.bukkit.converter.serverbound.playerCommand

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.wrappers.EnumWrappers
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.exceptions.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.enums.PlayerCommandAction
import ru.melonhell.packetframework.core.protocol.game.serverbound.SbPlayerCommandPacketWrapper
import ru.melonhell.packetframework.core.protocol.game.serverbound.SbPlayerInputPacketWrapper

@ProtocolVersion("1.8", "latest", SbPlayerCommandPacketWrapper::class)
class PlayerCommandPacketConverter_v1_8_0 : PacketConverter {

    private val playerCommandActions = PlayerCommandAction.values()
    private val playerActionsProtocolLib = EnumWrappers.PlayerAction.values()

    override fun wrap(container: PacketContainer): SbPlayerCommandPacketWrapper {
        val playerId = container.integers.read(0)
        val playerAction = container.playerActions.read(0)
        val data = container.integers.read(1)
        return SbPlayerCommandPacketWrapper(playerId, playerCommandActions[playerAction.ordinal], data)
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is SbPlayerCommandPacketWrapper) throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Client.ENTITY_ACTION)
        container.integers.write(0, wrapper.playerId)
        container.playerActions.write(0, playerActionsProtocolLib[wrapper.action.ordinal])
        container.integers.write(1, wrapper.data)
        return listOf(container)
    }

    override fun getWrapTypes() = listOf(PacketType.Play.Client.ENTITY_ACTION)
}
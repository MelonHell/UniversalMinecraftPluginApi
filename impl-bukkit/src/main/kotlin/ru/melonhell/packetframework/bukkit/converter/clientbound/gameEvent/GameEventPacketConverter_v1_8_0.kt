package ru.melonhell.packetframework.bukkit.converter.clientbound.gameEvent

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.exceptions.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.enums.GameEvent
import ru.melonhell.packetframework.core.protocol.game.clientbound.CbGameEventPacketWrapper

@ProtocolVersion("1.8", "latest")
class GameEventPacketConverter_v1_8_0 : PacketConverter {
    private val gameEvents = GameEvent.values()
    override fun wrap(container: PacketContainer): CbGameEventPacketWrapper {
        val gameStateId = container.gameStateIDs.read(0)
        val value = container.float.read(0)
        return CbGameEventPacketWrapper(gameEvents[gameStateId], value)
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is CbGameEventPacketWrapper) throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.GAME_STATE_CHANGE)
        container.gameStateIDs.write(0, wrapper.gameEvent.ordinal)
        container.float.write(0, wrapper.value)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.GAME_STATE_CHANGE)
    override val wrapperType = CbGameEventPacketWrapper::class
}
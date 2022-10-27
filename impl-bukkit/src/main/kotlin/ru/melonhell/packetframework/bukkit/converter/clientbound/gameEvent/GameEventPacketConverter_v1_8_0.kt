package ru.melonhell.packetframework.bukkit.converter.clientbound.gameEvent

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.converter.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.protocol.game.clientbound.ClientboundGameEventPacketWrapper

@ProtocolVersion("1.8", "latest", ClientboundGameEventPacketWrapper::class)
class GameEventPacketConverter_v1_8_0 : PacketConverter {

    private val gameEvents = ClientboundGameEventPacketWrapper.GameEvent.values()

    override fun wrap(container: PacketContainer): ClientboundGameEventPacketWrapper {
        val gameStateId = container.gameStateIDs.read(0)
        val value = container.float.read(0)
        return ClientboundGameEventPacketWrapper(gameEvents[gameStateId], value)
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is ClientboundGameEventPacketWrapper) throw WrongConverterException(wrapper::class, this::class)
        val container = PacketContainer(PacketType.Play.Server.GAME_STATE_CHANGE)
        container.gameStateIDs.write(0, wrapper.gameEvent.ordinal)
        container.float.write(0, wrapper.value)
        return listOf(container)
    }

    override fun getWrapTypes(): Collection<PacketType> {
        return listOf(PacketType.Play.Server.GAME_STATE_CHANGE)
    }
}
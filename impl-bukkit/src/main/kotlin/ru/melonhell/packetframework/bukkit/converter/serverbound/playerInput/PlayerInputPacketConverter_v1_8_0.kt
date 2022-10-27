package ru.melonhell.packetframework.bukkit.converter.serverbound.playerInput

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.converter.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.protocol.game.serverbound.ServerboundPlayerInputPacketWrapper

@ProtocolVersion("1.8", "latest", ServerboundPlayerInputPacketWrapper::class)
class PlayerInputPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): PacketWrapper {
        val sideways: Float = container.float.read(0)
        val forward: Float = container.float.read(1)
        val jumping: Boolean = container.booleans.read(0)
        val sneaking: Boolean = container.booleans.read(1)
        return ServerboundPlayerInputPacketWrapper(forward, sideways, jumping, sneaking)
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is ServerboundPlayerInputPacketWrapper) throw WrongConverterException(wrapper::class, this::class)
        val container = PacketContainer(PacketType.Play.Client.STEER_VEHICLE)
        container.float.write(0, wrapper.sideways)
        container.float.write(1, wrapper.forward)
        container.booleans.write(0, wrapper.jumping)
        container.booleans.write(1, wrapper.sneaking)
        return listOf(container)
    }

    override fun getWrapTypes(): Collection<PacketType> {
        return listOf(PacketType.Play.Client.STEER_VEHICLE)
    }
}
package ru.melonhell.packetframework.bukkit.converter.serverbound.movePlayer

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.converter.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.protocol.game.serverbound.ServerboundMovePlayerPacketWrapper

@ProtocolVersion("1.8", "latest", ServerboundMovePlayerPacketWrapper::class)
class MovePlayerPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): PacketWrapper {
        val type: PacketType = container.type
        var hasPos = false
        var hasRot = false
        var x = 0.0
        var y = 0.0
        var z = 0.0
        var yaw = 0f
        var pitch = 0f
        val onGround: Boolean = container.booleans.read(0)

        // set hasPos, hasRot
        if (type === PacketType.Play.Client.POSITION_LOOK) {
            hasPos = true
            hasRot = true
        } else if (type === PacketType.Play.Client.POSITION) {
            hasPos = true
        } else if (type === PacketType.Play.Client.LOOK) {
            hasRot = true
        }
        // set pos
        if (hasPos) {
            x = container.doubles.read(0)
            y = container.doubles.read(1)
            z = container.doubles.read(2)
        }
        // set rot
        if (hasRot) {
            yaw = container.float.read(0)
            pitch = container.float.read(1)
        }

        return ServerboundMovePlayerPacketWrapper(x, y, z, yaw, pitch, onGround, hasPos, hasRot)
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is ServerboundMovePlayerPacketWrapper) throw WrongConverterException(wrapper::class, this::class)

        val packetType: PacketType =
            if (wrapper.hasPos && wrapper.hasRot) PacketType.Play.Client.POSITION_LOOK
            else if (wrapper.hasPos) PacketType.Play.Client.POSITION
            else if (wrapper.hasRot) PacketType.Play.Client.LOOK
            else PacketType.Play.Client.GROUND

        val container = PacketContainer(packetType)
        container.booleans.write(0, wrapper.onGround)
        if (wrapper.hasPos) {
            container.doubles.write(0, wrapper.x)
            container.doubles.write(1, wrapper.y)
            container.doubles.write(2, wrapper.z)
        }
        if (wrapper.hasRot) {
            container.float.write(0, wrapper.yaw)
            container.float.write(1, wrapper.pitch)
        }
        return listOf(container)
    }

    override fun getWrapTypes(): Collection<PacketType> {
        return listOf(
            PacketType.Play.Client.POSITION_LOOK,
            PacketType.Play.Client.POSITION,
            PacketType.Play.Client.LOOK,
            PacketType.Play.Client.GROUND
        )
    }
}
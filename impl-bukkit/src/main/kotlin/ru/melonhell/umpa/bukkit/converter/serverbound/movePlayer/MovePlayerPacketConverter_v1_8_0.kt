package ru.melonhell.umpa.bukkit.converter.serverbound.movePlayer

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.converter.PacketConverter
import ru.melonhell.umpa.bukkit.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.exceptions.WrongConverterException
import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer
import ru.melonhell.umpa.core.packet.containers.serverbound.UmpaSbPlayerMovePacket
import ru.melonhell.umpa.core.utils.Look
import ru.melonhell.umpa.core.utils.Vector
import java.util.*

@ProtocolVersion("1.8", "latest")
class MovePlayerPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaSbPlayerMovePacket {
        val type = container.type
        val hasPosition = type == PacketType.Play.Client.POSITION_LOOK || type == PacketType.Play.Client.POSITION
        val position =
            if (hasPosition) Optional.of(
                Vector(
                    container.doubles.read(0),
                    container.doubles.read(1),
                    container.doubles.read(2)
                )
            )
            else Optional.empty()
        val hasRotation = type == PacketType.Play.Client.POSITION_LOOK || type == PacketType.Play.Client.LOOK
        val rotation =
            if (hasRotation) Optional.of(
                Look(
                    container.float.read(0),
                    container.float.read(1)
                )
            )
            else Optional.empty()
        val onGround: Boolean = container.booleans.read(0)
        return UmpaSbPlayerMovePacket(position, rotation, onGround)
    }

    override fun unwrap(wrapper: UmpaPacketContainer): List<PacketContainer> {
        if (wrapper !is UmpaSbPlayerMovePacket) throw WrongConverterException(wrapper, this)

        val hasPosition = wrapper.position.isPresent
        val hasRotation = wrapper.rotation.isPresent
        val packetType: PacketType =
            if (hasPosition && hasRotation) PacketType.Play.Client.POSITION_LOOK
            else if (hasPosition) PacketType.Play.Client.POSITION
            else if (hasRotation) PacketType.Play.Client.LOOK
            else PacketType.Play.Client.GROUND

        val container = PacketContainer(packetType)
        if (hasPosition) {
            val position = wrapper.position.get()
            container.doubles.write(0, position.x)
            container.doubles.write(1, position.y)
            container.doubles.write(2, position.z)
        }
        if (hasRotation) {
            val rotation = wrapper.rotation.get()
            container.float.write(0, rotation.yaw)
            container.float.write(1, rotation.pitch)
        }
        container.booleans.write(0, wrapper.onGround)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(
        PacketType.Play.Client.POSITION_LOOK,
        PacketType.Play.Client.POSITION,
        PacketType.Play.Client.LOOK,
        PacketType.Play.Client.GROUND
    )
    override val wrapperType = UmpaSbPlayerMovePacket::class
}
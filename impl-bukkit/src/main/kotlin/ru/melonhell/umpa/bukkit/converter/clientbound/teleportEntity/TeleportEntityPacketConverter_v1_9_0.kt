package ru.melonhell.umpa.bukkit.converter.clientbound.teleportEntity

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.converter.PacketConverter
import ru.melonhell.umpa.bukkit.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.exceptions.WrongConverterException
import ru.melonhell.umpa.core.protocol.game.clientbound.CbTeleportEntityPacketWrapper
import ru.melonhell.umpa.core.utils.Look
import ru.melonhell.umpa.core.utils.Vector

@ProtocolVersion("1.9", "latest")
class TeleportEntityPacketConverter_v1_9_0 : PacketConverter {
    override fun wrap(container: PacketContainer): CbTeleportEntityPacketWrapper {
        val entityId = container.integers.read(0)
        val position = Vector(
            container.doubles.read(0),
            container.doubles.read(1),
            container.doubles.read(2)
        )
        val rotation = Look(
            container.bytes.read(0) * 360.0f / 256.0f,
            container.bytes.read(1) * 360.0f / 256.0f
        )
        val onGround = container.booleans.read(0)
        return CbTeleportEntityPacketWrapper(entityId, position, rotation, onGround)
    }

    override fun unwrap(wrapper: ru.melonhell.umpa.core.PacketWrapper): List<PacketContainer> {
        if (wrapper !is CbTeleportEntityPacketWrapper)
            throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.ENTITY_TELEPORT)
        container.integers.write(0, wrapper.entityId)
        container.doubles.write(0, wrapper.position.x)
        container.doubles.write(1, wrapper.position.y)
        container.doubles.write(2, wrapper.position.z)
        container.bytes.write(0, (wrapper.rotation.yaw * 256.0f / 360.0f).toInt().toByte())
        container.bytes.write(1, (wrapper.rotation.pitch * 256.0f / 360.0f).toInt().toByte())
        container.booleans.write(0, wrapper.onGround)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.ENTITY_TELEPORT)
    override val wrapperType = CbTeleportEntityPacketWrapper::class
}
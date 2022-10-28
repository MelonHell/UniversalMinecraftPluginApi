package ru.melonhell.packetframework.bukkit.converter.clientbound.teleportEntity

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.exceptions.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.protocol.game.clientbound.CbTeleportEntityPacketWrapper
import ru.melonhell.packetframework.core.utils.Look
import ru.melonhell.packetframework.core.utils.Vector

@ProtocolVersion("1.8", "1.8.9", CbTeleportEntityPacketWrapper::class)
class TeleportEntityPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): CbTeleportEntityPacketWrapper {
        val entityId = container.integers.read(0)
        val position = Vector(
            container.integers.read(1) / 32.0,
            container.integers.read(2) / 32.0,
            container.integers.read(3) / 32.0
        )
        val rotation = Look(
            container.bytes.read(0) * 360.0f / 256.0f,
            container.bytes.read(1) * 360.0f / 256.0f
        )
        val onGround = container.booleans.read(0)
        return CbTeleportEntityPacketWrapper(entityId, position, rotation, onGround)
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is CbTeleportEntityPacketWrapper) throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.ENTITY_TELEPORT)
        container.integers.write(0, wrapper.entityId)
        container.integers.write(1, (wrapper.position.x * 32).toInt())
        container.integers.write(2, (wrapper.position.y * 32).toInt())
        container.integers.write(3, (wrapper.position.z * 32).toInt())
        container.bytes.write(0, (wrapper.rotation.yaw * 256.0f / 360.0f).toInt().toByte())
        container.bytes.write(1, (wrapper.rotation.pitch * 256.0f / 360.0f).toInt().toByte())
        container.booleans.write(0, wrapper.onGround)
        return listOf(container)
    }

    override fun getWrapTypes() = listOf(PacketType.Play.Server.ENTITY_TELEPORT)
}
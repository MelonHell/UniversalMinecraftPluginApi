package ru.melonhell.packetframework.bukkit.converter.clientbound.teleportEntity

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.converter.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.protocol.game.clientbound.ClientboundTeleportEntityPacketWrapper

@ProtocolVersion("1.8", "1.8.9", ClientboundTeleportEntityPacketWrapper::class)
class TeleportEntityPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): ClientboundTeleportEntityPacketWrapper {
        val entityId = container.integers.read(0)
        val yaw = container.bytes.read(0) * 360.0f / 256.0f
        val pitch = container.bytes.read(1) * 360.0f / 256.0f
        val locationX = container.integers.read(0) / 32.0
        val locationY = container.integers.read(1) / 32.0
        val locationZ = container.integers.read(2) / 32.0
        val isOnGround = container.booleans.read(0)
        return ClientboundTeleportEntityPacketWrapper(entityId, locationX, locationY, locationZ, yaw, pitch, isOnGround)
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is ClientboundTeleportEntityPacketWrapper) throw WrongConverterException(wrapper::class, this::class)
        val container = PacketContainer(PacketType.Play.Server.ENTITY_TELEPORT)
        container.integers.write(0, wrapper.entityId)
        container.bytes.write(0, (wrapper.yaw * 256.0f / 360.0f).toInt().toByte())
        container.bytes.write(1, (wrapper.pitch * 256.0f / 360.0f).toInt().toByte())
        container.integers.write(0, (wrapper.x * 32).toInt())
        container.integers.write(1, (wrapper.y * 32).toInt())
        container.integers.write(2, (wrapper.z * 32).toInt())
        container.booleans.write(0, wrapper.onGround)
        return listOf(container)
    }

    override fun getWrapTypes(): Collection<PacketType> {
        return listOf(PacketType.Play.Server.ENTITY_TELEPORT)
    }
}
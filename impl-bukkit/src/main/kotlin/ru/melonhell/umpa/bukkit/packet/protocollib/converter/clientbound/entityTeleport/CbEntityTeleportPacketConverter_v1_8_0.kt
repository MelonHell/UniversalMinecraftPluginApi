package ru.melonhell.umpa.bukkit.packet.protocollib.converter.clientbound.entityTeleport

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbEntityTeleportPacket
import ru.melonhell.umpa.core.utils.UmpaLook
import ru.melonhell.umpa.core.utils.UmpaVector

@MinMaxMinecraftVersion("1.8", "1.8.9")
class CbEntityTeleportPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaCbEntityTeleportPacket {
        val entityId = container.integers.read(0)
        val position = UmpaVector(
            container.integers.read(1) / 32.0,
            container.integers.read(2) / 32.0,
            container.integers.read(3) / 32.0
        )
        val rotation = UmpaLook(
            container.bytes.read(0) * 360.0f / 256.0f,
            container.bytes.read(1) * 360.0f / 256.0f
        )
        val onGround = container.booleans.read(0)
        return UmpaCbEntityTeleportPacket(entityId, position, rotation, onGround)
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaCbEntityTeleportPacket) throw UmpaWrongConverterException(wrapper, this)
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

    override val protocolLibTypes = listOf(PacketType.Play.Server.ENTITY_TELEPORT)
    override val packetType = UmpaPacketType.CB_ENTITY_TELEPORT
}
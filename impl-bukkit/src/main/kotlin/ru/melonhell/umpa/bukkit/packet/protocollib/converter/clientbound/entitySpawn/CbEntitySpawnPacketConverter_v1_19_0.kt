package ru.melonhell.umpa.bukkit.packet.protocollib.converter.clientbound.entitySpawn

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.utils.converter.BukkitEnumConverter.bukkit
import ru.melonhell.umpa.bukkit.utils.converter.BukkitEnumConverter.umpa
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.enums.keyed.UmpaEntityType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbEntitySpawnPacket
import ru.melonhell.umpa.core.utils.UmpaLook
import ru.melonhell.umpa.core.utils.UmpaVector
import java.util.*

@ProtocolVersion("1.19", "latest")
class CbEntitySpawnPacketConverter_v1_19_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaCbEntitySpawnPacket {
        if (container.type == PacketType.Play.Server.SPAWN_ENTITY_EXPERIENCE_ORB) {
            val entityId = container.integers.read(0)
            val position = UmpaVector(
                container.doubles.read(0),
                container.doubles.read(1),
                container.doubles.read(2)
            )
            val data = container.integers.read(1)
            return UmpaCbEntitySpawnPacket(
                entityId,
                UUID(0, 0),
                UmpaEntityType.EXPERIENCE_ORB,
                position,
                UmpaLook(0f, 0f),
                0f,
                data,
                UmpaVector(0.0, 0.0, 0.0)
            )
        }

        if (container.type == PacketType.Play.Server.NAMED_ENTITY_SPAWN) {
            val entityId = container.integers.read(0)
            val uuid = container.uuiDs.read(0)
            val position = UmpaVector(
                container.doubles.read(0),
                container.doubles.read(1),
                container.doubles.read(2)
            )
            val rotation = UmpaLook(
                container.bytes.read(0) * 360.0f / 256.0f,
                container.bytes.read(1) * 360.0f / 256.0f
            )
            return UmpaCbEntitySpawnPacket(
                entityId,
                uuid,
                UmpaEntityType.PLAYER,
                position,
                rotation,
                0f,
                0,
                UmpaVector(0.0, 0.0, 0.0)
            )
        }

        // Entity ID
        val entityId = container.integers.read(0)
        // UUID
        val uuid = container.uuiDs.read(0)
        // Entity Type
        val entityType = container.entityTypeModifier.read(0).umpa()
        // Yaw Pitch HeadYaw
        val rotation = UmpaLook(
            container.bytes.read(1) * 360.0f / 256.0f,
            container.bytes.read(0) * 360.0f / 256.0f
        )
        val headYaw = container.bytes.read(2) * 360.0f / 256.0f
        // Location
        val position = UmpaVector(
            container.doubles.read(0),
            container.doubles.read(1),
            container.doubles.read(2)
        )
        // Data
        val data = container.integers.read(4)
        // Velocity
        val velocityX = container.integers.read(1) / 8000.0
        val velocityY = container.integers.read(2) / 8000.0
        val velocityZ = container.integers.read(3) / 8000.0
        val velocity = UmpaVector(velocityX, velocityY, velocityZ)
        return UmpaCbEntitySpawnPacket(entityId, uuid, entityType, position, rotation, headYaw, data, velocity)
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaCbEntitySpawnPacket) throw UmpaWrongConverterException(wrapper, this)

        if (wrapper.entityType == UmpaEntityType.EXPERIENCE_ORB) {
            val container = PacketContainer(PacketType.Play.Server.SPAWN_ENTITY_EXPERIENCE_ORB)
            container.integers.write(0, wrapper.entityId)
            container.doubles.write(0, wrapper.position.x)
            container.doubles.write(1, wrapper.position.y)
            container.doubles.write(2, wrapper.position.z)
            container.integers.write(1, wrapper.data)
            return listOf(container)
        }

        if (wrapper.entityType == UmpaEntityType.PLAYER) {
            val container = PacketContainer(PacketType.Play.Server.NAMED_ENTITY_SPAWN)
            container.integers.write(0, wrapper.entityId)
            container.uuiDs.write(0, wrapper.uuid)
            container.doubles.write(0, wrapper.position.x)
            container.doubles.write(1, wrapper.position.y)
            container.doubles.write(2, wrapper.position.z)
            container.bytes.write(0, (wrapper.rotation.yaw * 256.0f / 360.0f).toInt().toByte())
            container.bytes.write(1, (wrapper.rotation.pitch * 256.0f / 360.0f).toInt().toByte())
            return listOf(container)
        }

        val container = PacketContainer(PacketType.Play.Server.SPAWN_ENTITY)
        // Entity ID
        container.integers.write(0, wrapper.entityId)
        // UUID
        container.uuiDs.write(0, wrapper.uuid)
        // Entity Type
        container.entityTypeModifier.write(0, wrapper.entityType.bukkit())
        // Yaw Pitch HeadYaw
        container.bytes.write(0, (wrapper.rotation.pitch * 256.0f / 360.0f).toInt().toByte())
        container.bytes.write(1, (wrapper.rotation.yaw * 256.0f / 360.0f).toInt().toByte())
        container.bytes.write(2, (wrapper.headYaw * 256.0f / 360.0f).toInt().toByte())
        // Location
        container.doubles.write(0, wrapper.position.x)
        container.doubles.write(1, wrapper.position.y)
        container.doubles.write(2, wrapper.position.z)
        // Data
        container.integers.write(4, wrapper.data)
        // Velocity
        container.integers.write(1, (wrapper.velocity.x * 8000).toInt())
        container.integers.write(2, (wrapper.velocity.y * 8000).toInt())
        container.integers.write(3, (wrapper.velocity.z * 8000).toInt())
        return listOf(container)
    }

    @Suppress("DEPRECATION")
    override val protocolLibTypes = listOf(
        PacketType.Play.Server.SPAWN_ENTITY,
        PacketType.Play.Server.SPAWN_ENTITY_EXPERIENCE_ORB,
        PacketType.Play.Server.NAMED_ENTITY_SPAWN,
        PacketType.Play.Server.SPAWN_ENTITY_LIVING,
        PacketType.Play.Server.SPAWN_ENTITY_PAINTING
    )
    override val packetType = UmpaPacketType.CB_ENTITY_SPAWN
}
package ru.melonhell.umpa.bukkit.packet.protocollib.converter.clientbound.entityVelocity

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbEntityVelocityPacket
import ru.melonhell.umpa.core.utils.UmpaVector

@MinMaxMinecraftVersion("1.8", "latest")
class CbEntityVelocityPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaCbEntityVelocityPacket {
        val entityId = container.integers.read(0)
        val velocity = UmpaVector(
            container.integers.read(1) / 8000.0,
            container.integers.read(2) / 8000.0,
            container.integers.read(3) / 8000.0
        )
        return UmpaCbEntityVelocityPacket(entityId, velocity)
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaCbEntityVelocityPacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.ENTITY_VELOCITY)
        container.integers.write(0, wrapper.entityId)
        container.integers.write(1, (wrapper.velocity.x * 8000).toInt())
        container.integers.write(2, (wrapper.velocity.y * 8000).toInt())
        container.integers.write(3, (wrapper.velocity.z * 8000).toInt())
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.ENTITY_VELOCITY)
    override val packetType = UmpaPacketType.CB_ENTITY_VELOCITY
}
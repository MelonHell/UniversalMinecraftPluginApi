package ru.melonhell.umpa.bukkit.packet.protocollib.converter.clientbound.entityHeadRotation

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.bukkit.utils.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbEntityHeadRotationPacket

@MinMaxMinecraftVersion("1.8", "latest")
class CbEntityHeadRotationPacketConverter_v1_8_0 : PacketConverter {

    override fun wrap(container: PacketContainer): UmpaCbEntityHeadRotationPacket {
        val entityId = container.integers.read(0)
        val headYaw = container.bytes.read(0) * 360.0f / 256.0f
        return UmpaCbEntityHeadRotationPacket(entityId, headYaw)
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaCbEntityHeadRotationPacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.ENTITY_HEAD_ROTATION)
        container.integers.write(0, wrapper.entityId)
        container.bytes.write(0, (wrapper.headYaw * 256.0f / 360.0f).toInt().toByte())
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.ENTITY_HEAD_ROTATION)
    override val packetType = UmpaPacketType.CB_ENTITY_HEAD_ROTATION
}
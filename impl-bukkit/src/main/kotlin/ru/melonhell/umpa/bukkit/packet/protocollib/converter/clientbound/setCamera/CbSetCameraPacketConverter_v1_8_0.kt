package ru.melonhell.umpa.bukkit.packet.protocollib.converter.clientbound.setCamera

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbSetCameraPacket

@ProtocolVersion("1.8", "latest")
class CbSetCameraPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaCbSetCameraPacket {
        val entityId = container.integers.read(0)
        return UmpaCbSetCameraPacket(entityId)
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaCbSetCameraPacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.CAMERA)
        container.integers.write(0, wrapper.cameraId)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.CAMERA)
    override val packetType = UmpaPacketType.CB_SET_CAMERA
}
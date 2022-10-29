package ru.melonhell.umpa.bukkit.converter.clientbound.setCamera

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.converter.PacketConverter
import ru.melonhell.umpa.bukkit.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.exceptions.WrongConverterException
import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbSetCameraPacket

@ProtocolVersion("1.8", "latest")
class SetCameraPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaCbSetCameraPacket {
        val entityId = container.integers.read(0)
        return UmpaCbSetCameraPacket(entityId)
    }

    override fun unwrap(wrapper: UmpaPacketContainer): List<PacketContainer> {
        if (wrapper !is UmpaCbSetCameraPacket) throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.CAMERA)
        container.integers.write(0, wrapper.cameraId)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.CAMERA)
    override val wrapperType = UmpaCbSetCameraPacket::class
}
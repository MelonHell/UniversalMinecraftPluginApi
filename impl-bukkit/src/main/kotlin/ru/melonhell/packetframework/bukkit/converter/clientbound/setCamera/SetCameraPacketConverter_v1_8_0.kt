package ru.melonhell.packetframework.bukkit.converter.clientbound.setCamera

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.exceptions.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.protocol.game.clientbound.CbSetCameraPacketWrapper

@ProtocolVersion("1.8", "latest", CbSetCameraPacketWrapper::class)
class SetCameraPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): CbSetCameraPacketWrapper {
        val entityId = container.integers.read(0)
        return CbSetCameraPacketWrapper(entityId)
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is CbSetCameraPacketWrapper) throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.CAMERA)
        container.integers.write(0, wrapper.cameraId)
        return listOf(container)
    }

    override fun getWrapTypes() = listOf(PacketType.Play.Server.CAMERA)
}
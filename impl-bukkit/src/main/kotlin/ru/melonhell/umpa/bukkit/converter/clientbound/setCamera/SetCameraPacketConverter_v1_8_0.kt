package ru.melonhell.umpa.bukkit.converter.clientbound.setCamera

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.converter.PacketConverter
import ru.melonhell.umpa.bukkit.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.exceptions.WrongConverterException
import ru.melonhell.umpa.core.protocol.game.clientbound.CbSetCameraPacketWrapper

@ProtocolVersion("1.8", "latest")
class SetCameraPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): CbSetCameraPacketWrapper {
        val entityId = container.integers.read(0)
        return CbSetCameraPacketWrapper(entityId)
    }

    override fun unwrap(wrapper: ru.melonhell.umpa.core.PacketWrapper): List<PacketContainer> {
        if (wrapper !is CbSetCameraPacketWrapper) throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.CAMERA)
        container.integers.write(0, wrapper.cameraId)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.CAMERA)
    override val wrapperType = CbSetCameraPacketWrapper::class
}
package ru.melonhell.packetframework.bukkit.converter.clientbound.setCamera

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.converter.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.protocol.game.clientbound.ClientboundSetCameraPacketWrapper

@ProtocolVersion("1.8", "latest", ClientboundSetCameraPacketWrapper::class)
class SetCameraPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): ClientboundSetCameraPacketWrapper {
        val entityId = container.integers.read(0)
        return ClientboundSetCameraPacketWrapper(entityId)
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is ClientboundSetCameraPacketWrapper) throw WrongConverterException(wrapper::class, this::class)
        val container = PacketContainer(PacketType.Play.Server.CAMERA)
        container.integers.write(0, wrapper.cameraId)
        return listOf(container)
    }

    override fun getWrapTypes(): Collection<PacketType> {
        return listOf(PacketType.Play.Server.CAMERA)
    }
}
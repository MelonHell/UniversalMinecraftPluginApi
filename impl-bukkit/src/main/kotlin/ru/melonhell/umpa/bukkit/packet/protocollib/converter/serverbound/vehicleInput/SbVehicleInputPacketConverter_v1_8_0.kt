package ru.melonhell.umpa.bukkit.packet.protocollib.converter.serverbound.vehicleInput

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.serverbound.UmpaSbVehicleInputPacket

@ProtocolVersion("1.8", "latest")
class SbVehicleInputPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaSbVehicleInputPacket {
        val sideways: Float = container.float.read(0)
        val forward: Float = container.float.read(1)
        val jumping: Boolean = container.booleans.read(0)
        val sneaking: Boolean = container.booleans.read(1)
        return UmpaSbVehicleInputPacket(forward, sideways, jumping, sneaking)
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaSbVehicleInputPacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Client.STEER_VEHICLE)
        container.float.write(0, wrapper.sideways)
        container.float.write(1, wrapper.forward)
        container.booleans.write(0, wrapper.jumping)
        container.booleans.write(1, wrapper.sneaking)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Client.STEER_VEHICLE)
    override val packetType = UmpaPacketType.SB_VEHICLE_INPUT
}
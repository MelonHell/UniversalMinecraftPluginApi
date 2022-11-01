package ru.melonhell.umpa.bukkit.packet.protocollib.converter.clientbound.entityPassengers

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.bukkit.utils.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbEntityPassengersPacket

@MinMaxMinecraftVersion("1.9", "latest")
class CbEntityPassengersPacketConverter_v1_9_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaCbEntityPassengersPacket {
        val entityId = container.integers.read(0)
        val passengerIds = container.integerArrays.read(0).toList()
        return UmpaCbEntityPassengersPacket(entityId, passengerIds)
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaCbEntityPassengersPacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.MOUNT)
        container.integers.write(0, wrapper.vehicleId)
        container.integerArrays.write(0, wrapper.passengerIds.toIntArray())
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.MOUNT)
    override val packetType = UmpaPacketType.CB_ENTITY_PASSENGERS
}
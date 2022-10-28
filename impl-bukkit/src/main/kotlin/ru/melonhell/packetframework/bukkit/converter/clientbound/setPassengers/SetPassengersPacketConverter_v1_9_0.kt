package ru.melonhell.packetframework.bukkit.converter.clientbound.setPassengers

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.exceptions.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.protocol.game.clientbound.CbSetPassengersPacketWrapper

@ProtocolVersion("1.9", "latest")
class SetPassengersPacketConverter_v1_9_0 : PacketConverter {
    override fun wrap(container: PacketContainer): CbSetPassengersPacketWrapper {
        val entityId = container.integers.read(0)
        val passengerIds = container.integerArrays.read(0).toList()
        return CbSetPassengersPacketWrapper(entityId, passengerIds)
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is CbSetPassengersPacketWrapper) throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.MOUNT)
        container.integers.write(0, wrapper.vehicleId)
        container.integerArrays.write(0, wrapper.passengerIds.toIntArray())
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.MOUNT)
    override val wrapperType = CbSetPassengersPacketWrapper::class
}
package ru.melonhell.packetframework.bukkit.converter.clientbound.setPassengers

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.converter.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.protocol.game.clientbound.ClientboundSetPassengersPacketWrapper

@ProtocolVersion("1.9", "latest", ClientboundSetPassengersPacketWrapper::class)
class SetPassengersPacketConverter_v1_9_0 : PacketConverter {
    override fun wrap(container: PacketContainer): ClientboundSetPassengersPacketWrapper {
        val entityId = container.integers.read(0)
        val passengerIds = container.integerArrays.read(0).toList()
        return ClientboundSetPassengersPacketWrapper(entityId, passengerIds)
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is ClientboundSetPassengersPacketWrapper) throw WrongConverterException(
            wrapper::class,
            this::class
        )
        val container = PacketContainer(PacketType.Play.Server.MOUNT)
        container.integers.write(0, wrapper.vehicleId)
        container.integerArrays.write(0, wrapper.passengerIds.toIntArray())
        return listOf(container)
    }

    override fun getWrapTypes(): Collection<PacketType> {
        return listOf(PacketType.Play.Server.MOUNT)
    }
}
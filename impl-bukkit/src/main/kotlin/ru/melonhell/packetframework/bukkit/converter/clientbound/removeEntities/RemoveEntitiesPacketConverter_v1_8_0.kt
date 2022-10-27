package ru.melonhell.packetframework.bukkit.converter.clientbound.removeEntities

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.converter.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.protocol.game.clientbound.ClientboundRemoveEntitiesPacketWrapper

@ProtocolVersion("1.8", "1.16.5", ClientboundRemoveEntitiesPacketWrapper::class)
class RemoveEntitiesPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): PacketWrapper {
        val entityIds = container.integerArrays.read(0)
        return ClientboundRemoveEntitiesPacketWrapper(entityIds.toList())
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is ClientboundRemoveEntitiesPacketWrapper) throw WrongConverterException(wrapper::class, this::class)
        val container = PacketContainer(PacketType.Play.Server.ENTITY_DESTROY)
        container.integerArrays.write(0, wrapper.entityIds.toIntArray())
        return listOf(container)
    }

    override fun getWrapTypes(): Collection<PacketType> {
        return listOf(PacketType.Play.Server.ENTITY_DESTROY)
    }
}
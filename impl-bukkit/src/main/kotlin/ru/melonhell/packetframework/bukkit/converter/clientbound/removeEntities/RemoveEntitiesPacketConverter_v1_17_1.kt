package ru.melonhell.packetframework.bukkit.converter.clientbound.removeEntities

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.exceptions.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.protocol.game.clientbound.CbRemoveEntitiesPacketWrapper

@ProtocolVersion("1.17.1", "latest")
class RemoveEntitiesPacketConverter_v1_17_1 : PacketConverter {
    override fun wrap(container: PacketContainer): CbRemoveEntitiesPacketWrapper {
        val entityIds = container.intLists.read(0)
        return CbRemoveEntitiesPacketWrapper(entityIds)
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is CbRemoveEntitiesPacketWrapper) throw WrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.ENTITY_DESTROY)
        container.intLists.write(0, wrapper.entityIds)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.ENTITY_DESTROY)
    override val wrapperType = CbRemoveEntitiesPacketWrapper::class
}
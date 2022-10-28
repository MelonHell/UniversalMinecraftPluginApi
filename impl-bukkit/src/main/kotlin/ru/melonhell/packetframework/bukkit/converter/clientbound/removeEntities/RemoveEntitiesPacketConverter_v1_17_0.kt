package ru.melonhell.packetframework.bukkit.converter.clientbound.removeEntities

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.converter.ProtocolVersion
import ru.melonhell.packetframework.bukkit.exceptions.WrongConverterException
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.protocol.game.clientbound.CbRemoveEntitiesPacketWrapper

@ProtocolVersion("1.17", "1.17", CbRemoveEntitiesPacketWrapper::class)
class RemoveEntitiesPacketConverter_v1_17_0 : PacketConverter {
    override fun wrap(container: PacketContainer): CbRemoveEntitiesPacketWrapper {
        val entityIds = container.integers.read(0)
        return CbRemoveEntitiesPacketWrapper(listOf(entityIds))
    }

    override fun unwrap(wrapper: PacketWrapper): List<PacketContainer> {
        if (wrapper !is CbRemoveEntitiesPacketWrapper) throw WrongConverterException(wrapper, this)
        return wrapper.entityIds.map {
            val container = PacketContainer(PacketType.Play.Server.ENTITY_DESTROY)
            container.integers.write(0, it)
            container
        }
    }

    override fun getWrapTypes() = listOf(PacketType.Play.Server.ENTITY_DESTROY)
}
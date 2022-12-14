package ru.melonhell.umpa.bukkit.packet.protocollib.converter.clientbound.entityRemove

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbEntityRemovePacket

@MinMaxMinecraftVersion("1.17", "1.17")
class CbEntityRemovePacketConverter_v1_17_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaCbEntityRemovePacket {
        val entityIds = container.integers.read(0)
        return UmpaCbEntityRemovePacket(listOf(entityIds))
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaCbEntityRemovePacket) throw UmpaWrongConverterException(wrapper, this)
        return wrapper.entityIds.map {
            val container = PacketContainer(PacketType.Play.Server.ENTITY_DESTROY)
            container.integers.write(0, it)
            container
        }
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.ENTITY_DESTROY)
    override val packetType = UmpaPacketType.CB_ENTITY_REMOVE
}
package ru.melonhell.umpa.bukkit.packet.protocollib.converter.clientbound.entityRemove

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbEntityRemovePacket

@MinMaxMinecraftVersion("1.17.1", "latest")
class CbEntityRemovePacketConverter_v1_17_1 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaCbEntityRemovePacket {
        val entityIds = container.intLists.read(0)
        return UmpaCbEntityRemovePacket(entityIds)
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaCbEntityRemovePacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.ENTITY_DESTROY)
        container.intLists.write(0, wrapper.entityIds)
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.ENTITY_DESTROY)
    override val packetType = UmpaPacketType.CB_ENTITY_REMOVE
}
package ru.melonhell.umpa.bukkit.packet.protocollib.converter.clientbound.entityRemove

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.ProtocolVersion
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbEntityRemovePacket

@ProtocolVersion("1.8", "1.16.5")
class CbEntityRemovePacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaCbEntityRemovePacket {
        val entityIds = container.integerArrays.read(0)
        return UmpaCbEntityRemovePacket(entityIds.toList())
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaCbEntityRemovePacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.ENTITY_DESTROY)
        container.integerArrays.write(0, wrapper.entityIds.toIntArray())
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.ENTITY_DESTROY)
    override val packetType = UmpaPacketType.CB_ENTITY_REMOVE
}
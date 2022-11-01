package ru.melonhell.umpa.bukkit.packet.protocollib.converter.clientbound.entityMetadata

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.umpa.bukkit.exceptions.UmpaWrongConverterException
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.bukkit.utils.MinMaxMinecraftVersion
import ru.melonhell.umpa.bukkit.wrappers.UmpaRawEntityMetadataProtocolLib
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.packet.containers.clientbound.UmpaCbEntityMetadataPacket
import java.util.stream.Collectors

@MinMaxMinecraftVersion("1.8", "latest")
class CbEntityMetadataPacketConverter_v1_8_0 : PacketConverter {
    override fun wrap(container: PacketContainer): UmpaCbEntityMetadataPacket {
        val entityId = container.integers.read(0)
        val metadata = container.watchableCollectionModifier.read(0)
        val metaMap = metadata.stream().collect(Collectors.toMap({ it.index }, { it }))
        return UmpaCbEntityMetadataPacket(entityId, UmpaRawEntityMetadataProtocolLib(metaMap))
    }

    override fun unwrap(wrapper: UmpaPacket): List<PacketContainer> {
        if (wrapper !is UmpaCbEntityMetadataPacket) throw UmpaWrongConverterException(wrapper, this)
        val container = PacketContainer(PacketType.Play.Server.ENTITY_METADATA)
        container.integers.write(0, wrapper.entityId)
        val metaMap = (wrapper.metadata as UmpaRawEntityMetadataProtocolLib).handle
        container.watchableCollectionModifier.write(0, ArrayList(metaMap.values))
        return listOf(container)
    }

    override val protocolLibTypes = listOf(PacketType.Play.Server.ENTITY_METADATA)
    override val packetType = UmpaPacketType.CB_ENTITY_METADATA
}
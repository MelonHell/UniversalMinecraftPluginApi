package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

data class UmpaCbEntityMetadataPacket(
    var entityId: Int,
    var metadata: UmpaRawEntityMetadata
) : UmpaPacket(UmpaPacketType.CB_ENTITY_METADATA) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
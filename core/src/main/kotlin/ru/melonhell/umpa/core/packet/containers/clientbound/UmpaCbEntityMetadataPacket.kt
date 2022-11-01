package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.wrappers.UmpaEntityMetaWrapper

data class UmpaCbEntityMetadataPacket(
    var entityId: Int,
    var metadata: UmpaEntityMetaWrapper
) : UmpaPacket(UmpaPacketType.CB_ENTITY_METADATA) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
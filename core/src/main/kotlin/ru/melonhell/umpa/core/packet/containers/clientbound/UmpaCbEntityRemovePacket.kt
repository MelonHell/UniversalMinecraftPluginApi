package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaCbEntityRemovePacket(
    var entityIds: List<Int>
) : UmpaPacket(UmpaPacketType.CB_ENTITY_REMOVE) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}

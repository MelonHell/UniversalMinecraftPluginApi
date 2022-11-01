package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.utils.UmpaVector

data class UmpaCbEntityVelocityPacket(
    var entityId: Int,
    var velocity: UmpaVector
) : UmpaPacket(UmpaPacketType.CB_ENTITY_VELOCITY) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
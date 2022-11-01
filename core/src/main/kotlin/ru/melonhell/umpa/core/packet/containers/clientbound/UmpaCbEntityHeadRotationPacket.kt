package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaCbEntityHeadRotationPacket(
    var entityId: Int,
    var headYaw: Float
) : UmpaPacket(UmpaPacketType.CB_ENTITY_HEAD_ROTATION) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
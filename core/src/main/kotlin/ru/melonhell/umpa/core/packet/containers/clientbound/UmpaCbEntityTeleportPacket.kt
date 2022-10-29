package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.utils.Look
import ru.melonhell.umpa.core.utils.Vector

data class UmpaCbEntityTeleportPacket(
    var entityId: Int,
    var position: Vector = Vector(),
    var rotation: Look = Look(),
    var onGround: Boolean = false
) : UmpaPacket(UmpaPacketType.CB_ENTITY_TELEPORT) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
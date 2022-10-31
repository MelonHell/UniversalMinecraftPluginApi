package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.utils.UmpaLook
import ru.melonhell.umpa.core.utils.UmpaVector

data class UmpaCbEntityTeleportPacket(
    var entityId: Int,
    var position: UmpaVector = UmpaVector(),
    var rotation: UmpaLook = UmpaLook(),
    var onGround: Boolean = false
) : UmpaPacket(UmpaPacketType.CB_ENTITY_TELEPORT) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
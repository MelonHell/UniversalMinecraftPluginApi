package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.utils.UmpaEntityLocation
import ru.melonhell.umpa.core.utils.UmpaLook
import ru.melonhell.umpa.core.utils.UmpaVector

data class UmpaCbEntityTeleportPacket @JvmOverloads constructor(
    var entityId: Int,
    var position: UmpaVector,
    var rotation: UmpaLook = UmpaLook(),
    var onGround: Boolean = false
) : UmpaPacket(UmpaPacketType.CB_ENTITY_TELEPORT) {

    @JvmOverloads
    constructor(entityId: Int, location: UmpaEntityLocation, onGround: Boolean = false) : this(
        entityId,
        location.position,
        location.look,
        onGround
    )

    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
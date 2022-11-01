package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.enums.keyed.UmpaEntityType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.utils.UmpaEntityLocation
import ru.melonhell.umpa.core.utils.UmpaLook
import ru.melonhell.umpa.core.utils.UmpaVector
import java.util.*

data class UmpaCbEntitySpawnPacket @JvmOverloads constructor(
    var entityId: Int,
    var uuid: UUID = UUID(0, 0),
    var entityType: UmpaEntityType,
    var position: UmpaVector,
    var rotation: UmpaLook = UmpaLook(),
    var headYaw: Float = 0f,
    var data: Int = 0,
    var velocity: UmpaVector = UmpaVector()
) : UmpaPacket(UmpaPacketType.CB_ENTITY_SPAWN) {

    constructor(
        entityId: Int,
        uuid: UUID = UUID(0, 0),
        entityType: UmpaEntityType,
        location: UmpaEntityLocation,
        headYaw: Float = 0f,
        data: Int = 0,
        velocity: UmpaVector = UmpaVector()
    ) : this(entityId, uuid, entityType, location.position, location.look, headYaw, data, velocity)

    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
package ru.melonhell.packetframework.core.protocol.game.clientbound

import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.enums.EntityType
import ru.melonhell.packetframework.core.utils.Look
import ru.melonhell.packetframework.core.utils.Vector
import java.util.*

data class CbAddEntityPacketWrapper(
    var entityId: Int,
    var uuid: UUID?, // null only for minecraft:experience_orb
    var entityType: EntityType,
    var position: Vector,
    var rotation: Look = Look(),
    var headYaw: Float = 0f,
    var data: Int = 0,
    var velocity: Vector = Vector()
    ) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }
}
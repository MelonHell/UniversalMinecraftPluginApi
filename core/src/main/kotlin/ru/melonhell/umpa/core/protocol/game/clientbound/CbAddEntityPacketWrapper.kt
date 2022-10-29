package ru.melonhell.umpa.core.protocol.game.clientbound

import ru.melonhell.umpa.core.utils.Look
import ru.melonhell.umpa.core.utils.Vector
import java.util.*

data class CbAddEntityPacketWrapper(
    var entityId: Int,
    var uuid: UUID?, // null only for minecraft:experience_orb
    var entityType: ru.melonhell.umpa.core.enums.EntityType,
    var position: Vector,
    var rotation: Look = Look(),
    var headYaw: Float = 0f,
    var data: Int = 0,
    var velocity: Vector = Vector()
) : ru.melonhell.umpa.core.PacketWrapper {
    override fun clone(): ru.melonhell.umpa.core.PacketWrapper {
        return this.copy()
    }
}
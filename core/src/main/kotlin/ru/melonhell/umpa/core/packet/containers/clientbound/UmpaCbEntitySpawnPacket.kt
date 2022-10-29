package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer
import ru.melonhell.umpa.core.utils.Look
import ru.melonhell.umpa.core.utils.Vector
import java.util.*

data class UmpaCbSpawnEntityPacket(
    var entityId: Int,
    var uuid: UUID?, // null only for minecraft:experience_orb
    var entityType: ru.melonhell.umpa.core.enums.EntityType,
    var position: Vector,
    var rotation: Look = Look(),
    var headYaw: Float = 0f,
    var data: Int = 0,
    var velocity: Vector = Vector()
) : UmpaPacketContainer {
    override fun clone(): UmpaPacketContainer {
        return this.copy()
    }
}
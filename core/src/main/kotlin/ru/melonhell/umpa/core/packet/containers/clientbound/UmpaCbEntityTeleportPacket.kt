package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer
import ru.melonhell.umpa.core.utils.Look
import ru.melonhell.umpa.core.utils.Vector

data class UmpaCbEntityTeleportPacket(
    var entityId: Int,
    var position: Vector = Vector(),
    var rotation: Look = Look(),
    var onGround: Boolean = false
) : UmpaPacketContainer {
    override fun clone(): UmpaPacketContainer {
        return this.copy()
    }
}
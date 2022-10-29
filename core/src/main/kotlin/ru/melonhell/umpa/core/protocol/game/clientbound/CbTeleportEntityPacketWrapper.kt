package ru.melonhell.umpa.core.protocol.game.clientbound

import ru.melonhell.umpa.core.utils.Look
import ru.melonhell.umpa.core.utils.Vector

data class CbTeleportEntityPacketWrapper(
    var entityId: Int,
    var position: Vector = Vector(),
    var rotation: Look = Look(),
    var onGround: Boolean = false
) : ru.melonhell.umpa.core.PacketWrapper {
    override fun clone(): ru.melonhell.umpa.core.PacketWrapper {
        return this.copy()
    }
}
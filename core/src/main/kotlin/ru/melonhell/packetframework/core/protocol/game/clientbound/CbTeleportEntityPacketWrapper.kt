package ru.melonhell.packetframework.core.protocol.game.clientbound

import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.utils.Look
import ru.melonhell.packetframework.core.utils.Vector

data class CbTeleportEntityPacketWrapper(
    var entityId: Int,
    var position: Vector = Vector(),
    var rotation: Look = Look(),
    var onGround: Boolean = false
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }
}
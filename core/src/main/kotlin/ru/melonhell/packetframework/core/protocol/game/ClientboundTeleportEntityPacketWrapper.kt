package ru.melonhell.packetframework.core.protocol.game

import ru.melonhell.packetframework.core.PacketWrapper

data class ClientboundTeleportEntityPacketWrapper(
    var entityId: Int,
    var x: Double,
    var y: Double,
    var z: Double,
    var yaw: Float,
    var pitch: Float,
    var onGround: Boolean
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }
}
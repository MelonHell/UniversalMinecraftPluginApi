package ru.melonhell.packetframework.core.protocol.game.serverbound

import ru.melonhell.packetframework.core.PacketWrapper

data class ServerboundMovePlayerPacketWrapper(
    var x: Double,
    var y: Double,
    var z: Double,
    var yaw: Float,
    var pitch: Float,
    var onGround: Boolean,

    var hasPos: Boolean,
    var hasRot: Boolean
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }
}

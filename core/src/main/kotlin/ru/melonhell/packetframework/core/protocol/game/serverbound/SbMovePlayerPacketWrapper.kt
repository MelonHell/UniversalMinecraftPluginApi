package ru.melonhell.packetframework.core.protocol.game.serverbound

import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.utils.Look
import ru.melonhell.packetframework.core.utils.Vector
import java.util.*

data class SbMovePlayerPacketWrapper(
    var position: Optional<Vector>,
    var rotation: Optional<Look>,
    var onGround: Boolean,
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }
}

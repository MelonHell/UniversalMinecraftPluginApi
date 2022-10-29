package ru.melonhell.umpa.core.protocol.game.serverbound

import ru.melonhell.umpa.core.utils.Look
import ru.melonhell.umpa.core.utils.Vector
import java.util.*

data class SbMovePlayerPacketWrapper(
    var position: Optional<Vector>,
    var rotation: Optional<Look>,
    var onGround: Boolean,
) : ru.melonhell.umpa.core.PacketWrapper {
    override fun clone(): ru.melonhell.umpa.core.PacketWrapper {
        return this.copy()
    }
}

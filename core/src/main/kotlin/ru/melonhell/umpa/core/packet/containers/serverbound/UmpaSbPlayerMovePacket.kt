package ru.melonhell.umpa.core.packet.containers.serverbound

import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.utils.Look
import ru.melonhell.umpa.core.utils.Vector
import java.util.*

data class UmpaSbPlayerMovePacket(
    var position: Optional<Vector>,
    var rotation: Optional<Look>,
    var onGround: Boolean,
) : UmpaPacket {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}

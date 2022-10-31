package ru.melonhell.umpa.core.packet.containers.serverbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.utils.UmpaLook
import ru.melonhell.umpa.core.utils.UmpaVector
import java.util.*

data class UmpaSbPlayerMovePacket(
    var position: Optional<UmpaVector>,
    var rotation: Optional<UmpaLook>,
    var onGround: Boolean,
) : UmpaPacket(UmpaPacketType.SB_PLAYER_MOVE) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}

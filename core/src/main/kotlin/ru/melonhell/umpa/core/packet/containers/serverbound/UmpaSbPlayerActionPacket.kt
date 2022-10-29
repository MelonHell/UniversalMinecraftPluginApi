package ru.melonhell.umpa.core.packet.containers.serverbound

import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaSbPlayerActionPacket(
    var playerId: Int, // Ignored by server
    var action: PlayerAction,
    var data: Int
) : UmpaPacket {
    override fun clone(): UmpaPacket {
        return this.copy()
    }

    enum class PlayerAction {
        PRESS_SHIFT_KEY,
        RELEASE_SHIFT_KEY,
        STOP_SLEEPING,
        START_SPRINTING,
        STOP_SPRINTING,
        START_RIDING_JUMP,
        STOP_RIDING_JUMP,
        OPEN_HORSE_INVENTORY,
        START_FALL_FLYING;
    }
}

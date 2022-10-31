package ru.melonhell.umpa.core.packet.containers.serverbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

/**
 * Sent by the client to indicate that it has performed certain actions:
 * sneaking (crouching), sprinting, exiting a bed, jumping with a horse,
 * and opening a horse's inventory while riding it.
 * */
data class UmpaSbPlayerActionPacket @JvmOverloads constructor(
    var playerId: Int = 0, // Ignored by server
    var action: Action,
    var data: Int = 0 // Only used by the “START_RIDING_JUMP” action, in which case it ranges from 0 to 100. In all other cases it is 0.
) : UmpaPacket(UmpaPacketType.SB_PLAYER_ACTION) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }

    enum class Action {
        PRESS_SHIFT_KEY,
        RELEASE_SHIFT_KEY,
        STOP_SLEEPING, // Leave bed is only sent when the “Leave Bed” button is clicked on the sleep GUI, not when waking up due today time.
        START_SPRINTING,
        STOP_SPRINTING,
        START_RIDING_JUMP,
        STOP_RIDING_JUMP,
        OPEN_HORSE_INVENTORY, // Open horse inventory is only sent when pressing the inventory key (default: E) while on a horse — all other methods of opening a horse's inventory (involving right-clicking or shift-right-clicking it) do not use this packet.
        START_FALL_FLYING;
    }
}

package ru.melonhell.umpa.core.packet.containers.serverbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.utils.UmpaVector

data class UmpaSbInteractEntityPacket(
    var entityId: Int,
    var action: Action,
    val target: UmpaVector = UmpaVector(), // Only if Type is interact at
    var hand: Hand = Hand.MAIN_HAND, // Only if Type is interact or interact at
    var sneaking: Boolean = false
) : UmpaPacket(UmpaPacketType.SB_INTERACT_ENTITY) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }

    enum class Action {
        INTERACT,
        ATTACK,
        INTERACT_AT;
    }

    enum class Hand {
        MAIN_HAND,
        OFF_HAND;
    }
}

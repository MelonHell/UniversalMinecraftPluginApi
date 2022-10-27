package ru.melonhell.packetframework.core.protocol.game.serverbound

import ru.melonhell.packetframework.core.PacketWrapper

data class ServerboundInteractPacketWrapper(
    var entityId: Int,
    var type: ActionType,
    var targetX: Float,
    var targetY: Float,
    var targetZ: Float,
    var hand: Hand,
    var sneaking: Boolean
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }

    enum class ActionType {
        INTERACT,
        ATTACK,
        INTERACT_AT;
    }

    enum class Hand {
        MAIN_HAND,
        OFF_HAND;
    }
}

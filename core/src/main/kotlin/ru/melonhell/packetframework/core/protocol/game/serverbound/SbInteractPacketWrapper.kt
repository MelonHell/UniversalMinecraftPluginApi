package ru.melonhell.packetframework.core.protocol.game.serverbound

import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.enums.Hand
import ru.melonhell.packetframework.core.enums.InteractAction

data class SbInteractPacketWrapper(
    var entityId: Int,
    var type: InteractAction,
    var targetX: Float = 0f,
    var targetY: Float = 0f,
    var targetZ: Float = 0f,
    var hand: Hand = Hand.MAIN_HAND,
    var sneaking: Boolean = false
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }
}

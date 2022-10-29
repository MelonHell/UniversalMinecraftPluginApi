package ru.melonhell.umpa.core.protocol.game.serverbound

import ru.melonhell.umpa.core.enums.Hand
import ru.melonhell.umpa.core.enums.InteractAction

data class SbInteractPacketWrapper(
    var entityId: Int,
    var type: InteractAction,
    var targetX: Float = 0f,
    var targetY: Float = 0f,
    var targetZ: Float = 0f,
    var hand: Hand = Hand.MAIN_HAND,
    var sneaking: Boolean = false
) : ru.melonhell.umpa.core.PacketWrapper {
    override fun clone(): ru.melonhell.umpa.core.PacketWrapper {
        return this.copy()
    }
}

package ru.melonhell.umpa.core.packet.containers.serverbound

import ru.melonhell.umpa.core.enums.Hand
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaSbInteractEntityPacket(
    var entityId: Int,
    var type: InteractType,
    var targetX: Float = 0f,
    var targetY: Float = 0f,
    var targetZ: Float = 0f,
    var hand: Hand = Hand.MAIN_HAND,
    var sneaking: Boolean = false
) : UmpaPacket {
    override fun clone(): UmpaPacket {
        return this.copy()
    }

    enum class InteractType {
        INTERACT,
        ATTACK,
        INTERACT_AT;
    }
}

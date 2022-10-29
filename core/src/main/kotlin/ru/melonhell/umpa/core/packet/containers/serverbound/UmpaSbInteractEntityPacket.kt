package ru.melonhell.umpa.core.packet.containers.serverbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaSbInteractEntityPacket(
    var entityId: Int,
    var type: InteractType,
    var targetX: Float = 0f,
    var targetY: Float = 0f,
    var targetZ: Float = 0f,
    var hand: InteractHand = InteractHand.MAIN_HAND,
    var sneaking: Boolean = false
) : UmpaPacket(UmpaPacketType.SB_INTERACT_ENTITY) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }

    enum class InteractType {
        INTERACT,
        ATTACK,
        INTERACT_AT;
    }

    enum class InteractHand {
        MAIN_HAND,
        OFF_HAND;
    }
}

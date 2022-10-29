package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaCbEntityAnimatePacket(
    var entityId: Int,
    var action: EntityAnimation
) : UmpaPacket(UmpaPacketType.CB_ENTITY_ANIMATE) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }

    enum class EntityAnimation {
        SWING_MAIN_HAND,
        HURT,
        WAKE_UP,
        SWING_OFF_HAND,
        CRITICAL_HIT,
        MAGIC_CRITICAL_HIT
    }
}
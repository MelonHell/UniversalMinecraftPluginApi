package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaCbEntityAnimatePacket(
    var entityId: Int,
    var action: EntityAnimation
) : UmpaPacket {
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
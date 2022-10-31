package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaCbWorldBorderPacket @JvmOverloads constructor(
    var action: Action,
    var newCenterX: Double = 0.0,
    var newCenterZ: Double = 0.0,
    var oldSize: Double = 0.0,
    var newSize: Double = 0.0,
    var lerpTime: Long = 0,
    var newAbsoluteMaxSize: Int = 0,
    var warningBlocks: Int = 0,
    var warningTime: Int = 0
) : UmpaPacket(UmpaPacketType.CB_WORLD_BORDER) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }

    enum class Action {
        INITIALIZE,
        SET_CENTER,
        SET_LERP_SIZE,
        SET_SIZE,
        SET_WARNING_TIME,
        SET_WARNING_BLOCKS;
    }
}
package ru.melonhell.umpa.core.protocol.game.clientbound

import ru.melonhell.umpa.core.enums.WorldBorderAction

data class CbWorldBorderPacketWrapper(
    var action: WorldBorderAction,
    var newCenterX: Double = 0.0,
    var newCenterZ: Double = 0.0,
    var oldSize: Double = 0.0,
    var newSize: Double = 0.0,
    var lerpTime: Long = 0,
    var newAbsoluteMaxSize: Int = 0,
    var warningBlocks: Int = 0,
    var warningTime: Int = 0
) : ru.melonhell.umpa.core.PacketWrapper {
    override fun clone(): ru.melonhell.umpa.core.PacketWrapper {
        return this.copy()
    }
}
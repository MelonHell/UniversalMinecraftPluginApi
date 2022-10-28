package ru.melonhell.packetframework.core.protocol.game.clientbound

import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.enums.WorldBorderAction

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
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }
}
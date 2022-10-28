package ru.melonhell.packetframework.core.protocol.game.clientbound

import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.utils.BlockPos

data class CbLevelEventPacketWrapper(
    var type: Int,
    var pos: BlockPos = BlockPos(),
    var data: Int = 0,
    var global: Boolean = false
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }
}
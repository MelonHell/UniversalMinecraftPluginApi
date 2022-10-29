package ru.melonhell.umpa.core.protocol.game.clientbound

import ru.melonhell.umpa.core.utils.BlockPos

data class CbLevelEventPacketWrapper(
    var type: Int,
    var pos: BlockPos = BlockPos(),
    var data: Int = 0,
    var global: Boolean = false
) : ru.melonhell.umpa.core.PacketWrapper {
    override fun clone(): ru.melonhell.umpa.core.PacketWrapper {
        return this.copy()
    }
}
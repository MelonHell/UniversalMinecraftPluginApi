package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.utils.BlockPos

data class UmpaCbWorldEventPacket(
    var type: Int,
    var pos: BlockPos = BlockPos(),
    var data: Int = 0,
    var global: Boolean = false
) : UmpaPacket {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
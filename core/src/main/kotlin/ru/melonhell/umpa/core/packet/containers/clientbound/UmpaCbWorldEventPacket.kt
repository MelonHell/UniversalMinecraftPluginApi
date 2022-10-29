package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer
import ru.melonhell.umpa.core.utils.BlockPos

data class UmpaCbWorldEventPacket(
    var type: Int,
    var pos: BlockPos = BlockPos(),
    var data: Int = 0,
    var global: Boolean = false
) : UmpaPacketContainer {
    override fun clone(): UmpaPacketContainer {
        return this.copy()
    }
}
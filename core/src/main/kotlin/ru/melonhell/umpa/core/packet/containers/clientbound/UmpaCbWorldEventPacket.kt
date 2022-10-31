package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.utils.UmpaBlockPos

data class UmpaCbWorldEventPacket(
    var type: Int,
    var pos: UmpaBlockPos = UmpaBlockPos(),
    var data: Int = 0,
    var global: Boolean = false
) : UmpaPacket(UmpaPacketType.CB_WORLD_EVENT) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
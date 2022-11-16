package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaCbSetHealthPacket(
    var health: Float,
    var food: Int,
    var foodSaturation: Float
) : UmpaPacket(UmpaPacketType.CB_SET_HEALTH) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
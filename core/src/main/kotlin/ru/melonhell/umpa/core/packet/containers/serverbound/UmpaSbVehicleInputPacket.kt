package ru.melonhell.umpa.core.packet.containers.serverbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaSbVehicleInputPacket(
    var sideways: Float,
    var forward: Float,
    var jumping: Boolean,
    var sneaking: Boolean
) : UmpaPacket(UmpaPacketType.SB_VEHICLE_INPUT) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}

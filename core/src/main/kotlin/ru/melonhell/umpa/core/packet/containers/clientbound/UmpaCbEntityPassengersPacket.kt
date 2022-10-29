package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaCbEntityPassengersPacket(
    var vehicleId: Int,
    var passengerIds: List<Int>
) : UmpaPacket {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
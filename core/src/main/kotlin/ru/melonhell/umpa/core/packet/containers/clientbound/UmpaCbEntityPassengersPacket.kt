package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer

data class UmpaCbEntityPassengersPacket(
    var vehicleId: Int,
    var passengerIds: List<Int>
) : UmpaPacketContainer {
    override fun clone(): UmpaPacketContainer {
        return this.copy()
    }
}
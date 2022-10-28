package ru.melonhell.packetframework.core.protocol.game.clientbound

import ru.melonhell.packetframework.core.PacketWrapper

data class CbSetPassengersPacketWrapper(
    var vehicleId: Int,
    var passengerIds: List<Int>
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }
}
package ru.melonhell.umpa.core.protocol.game.clientbound

data class CbSetPassengersPacketWrapper(
    var vehicleId: Int,
    var passengerIds: List<Int>
) : ru.melonhell.umpa.core.PacketWrapper {
    override fun clone(): ru.melonhell.umpa.core.PacketWrapper {
        return this.copy()
    }
}
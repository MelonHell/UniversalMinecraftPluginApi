package ru.melonhell.umpa.core.packet.containers.serverbound

import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer

data class UmpaSbVehicleInputPacket(
    var sideways: Float,
    var forward: Float,
    var jumping: Boolean,
    var sneaking: Boolean
) : UmpaPacketContainer {
    override fun clone(): UmpaPacketContainer {
        return this.copy()
    }
}

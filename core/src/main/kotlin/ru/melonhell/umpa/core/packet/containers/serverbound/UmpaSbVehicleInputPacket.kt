package ru.melonhell.umpa.core.packet.containers.serverbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaSbVehicleInputPacket(
    var sideways: Float = 0f, // Positive left
    var straight: Float = 0f, // Positive forward
    var jumping: Boolean = false,
    var sneaking: Boolean = false
) : UmpaPacket(UmpaPacketType.SB_VEHICLE_INPUT) {
    val forward get() = straight > 0
    val backward get() = straight < 0
    val left get() = sideways > 0
    val right get() = sideways < 0
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}

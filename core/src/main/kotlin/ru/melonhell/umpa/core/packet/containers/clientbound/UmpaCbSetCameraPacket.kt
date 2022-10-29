package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaCbSetCameraPacket(
    var cameraId: Int
) : UmpaPacket(UmpaPacketType.CB_SET_CAMERA) {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
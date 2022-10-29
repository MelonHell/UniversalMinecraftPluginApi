package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaCbSetCameraPacket(
    var cameraId: Int
) : UmpaPacket {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
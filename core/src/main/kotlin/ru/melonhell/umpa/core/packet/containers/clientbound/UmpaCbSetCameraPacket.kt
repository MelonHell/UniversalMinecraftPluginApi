package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer

data class UmpaCbSetCameraPacket(
    var cameraId: Int
) : UmpaPacketContainer {
    override fun clone(): UmpaPacketContainer {
        return this.copy()
    }
}
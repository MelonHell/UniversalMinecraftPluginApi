package ru.melonhell.umpa.core.protocol.game.clientbound

data class CbSetCameraPacketWrapper(
    var cameraId: Int
) : ru.melonhell.umpa.core.PacketWrapper {
    override fun clone(): ru.melonhell.umpa.core.PacketWrapper {
        return this.copy()
    }
}
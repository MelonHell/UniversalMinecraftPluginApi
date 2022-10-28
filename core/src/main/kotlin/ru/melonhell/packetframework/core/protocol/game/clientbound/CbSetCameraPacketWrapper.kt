package ru.melonhell.packetframework.core.protocol.game.clientbound

import ru.melonhell.packetframework.core.PacketWrapper

data class CbSetCameraPacketWrapper(
    var cameraId: Int
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }
}
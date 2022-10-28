package ru.melonhell.packetframework.core.protocol.game.clientbound

import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.enums.EntityAnimation

data class CbAnimatePacketWrapper(
    var entityId: Int,
    var action: EntityAnimation
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }
}
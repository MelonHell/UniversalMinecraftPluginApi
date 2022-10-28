package ru.melonhell.packetframework.core.protocol.game.clientbound

import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.enums.GameEvent

data class CbGameEventPacketWrapper(
    var gameEvent: GameEvent,
    var value: Float = 0f
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }
}
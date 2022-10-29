package ru.melonhell.umpa.core.protocol.game.clientbound

import ru.melonhell.umpa.core.enums.GameEvent

data class CbGameEventPacketWrapper(
    var gameEvent: GameEvent,
    var value: Float = 0f
) : ru.melonhell.umpa.core.PacketWrapper {
    override fun clone(): ru.melonhell.umpa.core.PacketWrapper {
        return this.copy()
    }
}
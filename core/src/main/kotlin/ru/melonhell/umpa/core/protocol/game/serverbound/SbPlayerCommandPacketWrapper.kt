package ru.melonhell.umpa.core.protocol.game.serverbound

import ru.melonhell.umpa.core.enums.PlayerCommandAction

data class SbPlayerCommandPacketWrapper(
    var playerId: Int, // Ignored by server
    var action: PlayerCommandAction,
    var data: Int
) : ru.melonhell.umpa.core.PacketWrapper {
    override fun clone(): ru.melonhell.umpa.core.PacketWrapper {
        return this.copy()
    }
}

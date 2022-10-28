package ru.melonhell.packetframework.core.protocol.game.serverbound

import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.enums.PlayerCommandAction

data class SbPlayerCommandPacketWrapper(
    var playerId: Int, // Ignored by server
    var action: PlayerCommandAction,
    var data: Int
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }
}

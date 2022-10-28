package ru.melonhell.packetframework.core.protocol.game.clientbound

import net.kyori.adventure.text.Component
import ru.melonhell.packetframework.core.PacketWrapper

data class CbPlayerCombatKillPacketWrapper(
    var playerId: Int,
    var killerId: Int,
    var message: Component
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }
}
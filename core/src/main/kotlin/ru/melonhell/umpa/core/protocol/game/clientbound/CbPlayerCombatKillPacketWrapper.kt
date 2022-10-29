package ru.melonhell.umpa.core.protocol.game.clientbound

import net.kyori.adventure.text.Component

data class CbPlayerCombatKillPacketWrapper(
    var playerId: Int,
    var killerId: Int,
    var message: Component
) : ru.melonhell.umpa.core.PacketWrapper {
    override fun clone(): ru.melonhell.umpa.core.PacketWrapper {
        return this.copy()
    }
}
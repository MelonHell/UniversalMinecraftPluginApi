package ru.melonhell.umpa.core.packet.containers.clientbound

import net.kyori.adventure.text.Component
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

data class UmpaCbPlayerCombatKillPacket(
    var playerId: Int,
    var killerId: Int,
    var message: Component
) : UmpaPacket {
    override fun clone(): UmpaPacket {
        return this.copy()
    }
}
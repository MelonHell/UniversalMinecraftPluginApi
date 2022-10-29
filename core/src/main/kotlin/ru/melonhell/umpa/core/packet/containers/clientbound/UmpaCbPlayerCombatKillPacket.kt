package ru.melonhell.umpa.core.packet.containers.clientbound

import net.kyori.adventure.text.Component
import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer

data class UmpaCbPlayerCombatKillPacket(
    var playerId: Int,
    var killerId: Int,
    var message: Component
) : UmpaPacketContainer {
    override fun clone(): UmpaPacketContainer {
        return this.copy()
    }
}
package ru.melonhell.packetframework.bukkit.event

import org.bukkit.entity.Player
import ru.melonhell.packetframework.core.event.PfPacketEvent

interface IBukkitPacketEvent : PfPacketEvent {
    val player: Player
}
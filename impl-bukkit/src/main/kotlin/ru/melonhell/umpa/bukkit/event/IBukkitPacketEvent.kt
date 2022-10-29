package ru.melonhell.umpa.bukkit.event

import org.bukkit.entity.Player
import ru.melonhell.umpa.core.event.PfPacketEvent

interface IBukkitPacketEvent : PfPacketEvent {
    val player: Player
}
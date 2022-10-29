package ru.melonhell.umpa.bukkit.event

import org.bukkit.entity.Player
import ru.melonhell.umpa.core.event.UmpaPacketEvent

interface IBukkitPacketEvent : UmpaPacketEvent {
    val player: Player
}
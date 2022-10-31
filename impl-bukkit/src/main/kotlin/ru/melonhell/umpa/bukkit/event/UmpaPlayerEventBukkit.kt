package ru.melonhell.umpa.bukkit.event

import org.bukkit.entity.Player
import ru.melonhell.umpa.core.event.trait.UmpaPlayerEvent

interface UmpaPlayerEventBukkit : UmpaPlayerEvent {
    val bukkitPlayer: Player
}
package ru.melonhell.umpa.bukkit.wrappers

import org.bukkit.entity.Player
import ru.melonhell.umpa.core.wrappers.UmpaPlayer
import java.util.*

class BukkitUmpaPlayer(val player: Player) : UmpaPlayer {
    override val name: String
        get() = player.name
    override val uuid: UUID
        get() = player.uniqueId
}
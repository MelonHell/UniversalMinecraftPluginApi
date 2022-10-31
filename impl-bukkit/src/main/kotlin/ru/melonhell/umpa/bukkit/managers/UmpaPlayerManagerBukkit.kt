package ru.melonhell.umpa.bukkit.managers

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import ru.melonhell.umpa.bukkit.wrappers.UmpaPlayerBukkit
import ru.melonhell.umpa.core.managers.UmpaPlayerManager
import java.util.*

class UmpaPlayerManagerBukkit : UmpaPlayerManager {
    override fun player(name: String) = Bukkit.getPlayer(name)?.let { UmpaPlayerBukkit(it) }
    override fun player(uuid: UUID) = Bukkit.getPlayer(uuid)?.let { UmpaPlayerBukkit(it) }
    override fun player(player: Any) = UmpaPlayerBukkit(player as Player)
}
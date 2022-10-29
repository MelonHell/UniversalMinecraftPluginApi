package ru.melonhell.umpa.bukkit

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import ru.melonhell.umpa.bukkit.wrappers.BukkitUmpaPlayer
import ru.melonhell.umpa.core.managers.UmpaPlayerManager
import java.util.*

class BukkitUmpaPlayerManager(javaPlugin: JavaPlugin) : UmpaPlayerManager {
    override fun getPlayer(name: String) = Bukkit.getPlayer(name)?.let { BukkitUmpaPlayer(it) }
    override fun getPlayer(uuid: UUID) = Bukkit.getPlayer(uuid)?.let { BukkitUmpaPlayer(it) }
    override fun getPlayer(player: Any) = BukkitUmpaPlayer(player as Player)
}
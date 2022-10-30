package ru.melonhell.umpa.bukkit.wrappers

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import ru.melonhell.umpa.core.wrappers.PluginWrapper

class BukkitPlugin(val handle: Plugin) : PluginWrapper  {
    override fun equals(other: Any?): Boolean {
        if (other !is BukkitPlugin) return false
        return handle == other.handle
    }
}
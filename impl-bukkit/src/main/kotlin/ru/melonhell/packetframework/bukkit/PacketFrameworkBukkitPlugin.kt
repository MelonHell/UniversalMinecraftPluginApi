package ru.melonhell.packetframework.bukkit

import org.bukkit.Bukkit
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import ru.melonhell.packetframework.core.PacketFramework

class PacketFrameworkBukkitPlugin : JavaPlugin(), Listener {
    override fun onEnable() {
        PacketFramework.packetFrameworkService = BukkitPacketFrameworkService(this)
    }

    override fun onDisable() {
        PacketFramework.packetFrameworkService = null
    }
}
package ru.melonhell.packetframework.bukkit

import org.bukkit.plugin.java.JavaPlugin
import ru.melonhell.packetframework.core.PacketFramework

class PacketFrameworkBukkitPlugin : JavaPlugin() {
    override fun onEnable() {
        PacketFramework.packetFrameworkService = BukkitPacketFrameworkService(this)
    }

    override fun onDisable() {
        PacketFramework.packetFrameworkService = null
    }
}
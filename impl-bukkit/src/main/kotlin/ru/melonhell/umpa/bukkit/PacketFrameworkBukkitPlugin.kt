package ru.melonhell.umpa.bukkit

import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class PacketFrameworkBukkitPlugin : JavaPlugin(), Listener {
    override fun onEnable() {
        setService(BukkitPacketFrameworkService(this))
    }

    override fun onDisable() {
        setService(null)
    }

    private fun setService(packetFrameworkService: ru.melonhell.umpa.core.PacketFrameworkService?) {
        val declaredField =
            ru.melonhell.umpa.core.PacketFramework::class.java.getDeclaredField("packetFrameworkService")
        declaredField.isAccessible = true
        declaredField.set(null, packetFrameworkService)
    }
}
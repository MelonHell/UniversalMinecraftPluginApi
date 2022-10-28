package ru.melonhell.packetframework.bukkit

import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin
import ru.melonhell.packetframework.core.PacketFramework
import ru.melonhell.packetframework.core.PacketFrameworkService

class PacketFrameworkBukkitPlugin : JavaPlugin(), Listener {
    override fun onEnable() {
        setService(BukkitPacketFrameworkService(this))
    }

    override fun onDisable() {
        setService(null)
    }

    private fun setService(packetFrameworkService: PacketFrameworkService?) {
        val declaredField = PacketFramework::class.java.getDeclaredField("packetFrameworkService")
        declaredField.isAccessible = true
        declaredField.set(null, packetFrameworkService)
    }
}
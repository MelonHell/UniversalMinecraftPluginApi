package ru.melonhell.umpa.bukkit

import org.bukkit.plugin.java.JavaPlugin
import ru.melonhell.umpa.core.Umpa

class UmpaJavaPlugin : JavaPlugin() {
    override fun onEnable() {
        setManager("playerManager", BukkitUmpaPlayerManager(this))
        setManager("packetManager", BukkitUmpaPacketManager(this))
    }

    override fun onDisable() {
        setManager("playerManager", null)
        setManager("packetManager", null)
    }

    private fun setManager(name: String, manager: Any?) {
        val declaredField = Umpa::class.java.getDeclaredField(name)
        declaredField.isAccessible = true
        declaredField.set(null, manager)
    }
}
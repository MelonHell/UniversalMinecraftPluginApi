package ru.melonhell.umpa.bukkit

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.server.PluginDisableEvent
import org.bukkit.plugin.java.JavaPlugin
import ru.melonhell.umpa.bukkit.packet.protocollib.BukkitUmpaPacketManager
import ru.melonhell.umpa.bukkit.wrappers.BukkitPlugin
import ru.melonhell.umpa.core.Umpa
import ru.melonhell.umpa.core.event.UmpaEventManager

class UmpaJavaPlugin : JavaPlugin(), Listener {

    lateinit var eventManager: UmpaEventManager
    override fun onEnable() {
        eventManager = UmpaEventManager()
        val packetManager = BukkitUmpaPacketManager(this, eventManager)
        val playerManager = BukkitUmpaPlayerManager(this)

        setManager("playerManager", playerManager)
        setManager("packetManager", packetManager)
        setManager("eventManager", eventManager)

        Bukkit.getPluginManager().registerEvents(this, this)
    }

    override fun onDisable() {
        setManager("playerManager", null)
        setManager("packetManager", null)
        setManager("eventManager", null)
    }

    private fun setManager(name: String, manager: Any?) {
        val declaredField = Umpa::class.java.getDeclaredField(name)
        declaredField.isAccessible = true
        declaredField.set(null, manager)
    }

    @EventHandler
    fun onPluginDisable(event: PluginDisableEvent) {
        eventManager.unsubscribe(BukkitPlugin(event.plugin))
    }
}
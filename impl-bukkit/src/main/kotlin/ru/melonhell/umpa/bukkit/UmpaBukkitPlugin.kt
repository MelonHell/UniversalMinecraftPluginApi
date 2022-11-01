package ru.melonhell.umpa.bukkit

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.server.PluginDisableEvent
import org.bukkit.plugin.java.JavaPlugin
import ru.melonhell.umpa.bukkit.managers.UmpaItemStackManagerBukkit
import ru.melonhell.umpa.bukkit.managers.UmpaPlayerManagerBukkit
import ru.melonhell.umpa.bukkit.packet.protocollib.UmpaPacketManagerProtocolLib
import ru.melonhell.umpa.bukkit.wrappers.UmpaPluginWrapperBukkit
import ru.melonhell.umpa.core.Umpa
import ru.melonhell.umpa.core.event.UmpaEventManager

class UmpaBukkitPlugin : JavaPlugin(), Listener {

    lateinit var eventManager: UmpaEventManager
    override fun onEnable() {
        eventManager = UmpaEventManager()
        val playerManager = UmpaPlayerManagerBukkit()
        val itemStackManager = UmpaItemStackManagerBukkit()
        val packetManager = UmpaPacketManagerProtocolLib(this, eventManager)

        setManager("playerManager", playerManager)
        setManager("packetManager", packetManager)
        setManager("eventManager", eventManager)
        setManager("itemStackManager", itemStackManager)

        Bukkit.getPluginManager().registerEvents(this, this)
    }

    override fun onDisable() {
        setManager("playerManager", null)
        setManager("packetManager", null)
        setManager("eventManager", null)
        setManager("itemStackManager", null)
    }

    private fun setManager(name: String, manager: Any?) {
        val declaredField = Umpa::class.java.getDeclaredField(name)
        declaredField.isAccessible = true
        declaredField.set(null, manager)
    }

    @EventHandler
    fun onPluginDisable(event: PluginDisableEvent) {
        eventManager.unsubscribe(UmpaPluginWrapperBukkit(event.plugin))
    }
}
package ru.melonhell.umpa.bukkit.event

import org.bukkit.plugin.java.JavaPlugin
import ru.melonhell.umpa.bukkit.wrappers.BukkitPlugin
import ru.melonhell.umpa.core.event.PacketListener
import ru.melonhell.umpa.core.event.UmpaPacketEvent

abstract class BukkitPacketListener(javaPlugin: JavaPlugin) : PacketListener(BukkitPlugin(javaPlugin)) {
    override fun onPacketSending(event: UmpaPacketEvent) {
        onPacketSending(event as IBukkitPacketEvent)
    }

    override fun onPacketReceiving(event: UmpaPacketEvent) {
        onPacketReceiving(event as IBukkitPacketEvent)
    }

    open fun onPacketSending(event: IBukkitPacketEvent) {}

    open fun onPacketReceiving(event: IBukkitPacketEvent) {}
}
package ru.melonhell.packetframework.bukkit.event

import org.bukkit.plugin.java.JavaPlugin
import ru.melonhell.packetframework.bukkit.wrappers.BukkitPlugin
import ru.melonhell.packetframework.core.event.PacketListener
import ru.melonhell.packetframework.core.event.PfPacketEvent

abstract class BukkitPacketListener(javaPlugin: JavaPlugin) : PacketListener(BukkitPlugin(javaPlugin)) {
    override fun onPacketSending(event: PfPacketEvent) {
        onPacketSending(event as IBukkitPacketEvent)
    }

    override fun onPacketReceiving(event: PfPacketEvent) {
        onPacketReceiving(event as IBukkitPacketEvent)
    }

    open fun onPacketSending(event: IBukkitPacketEvent) {}

    open fun onPacketReceiving(event: IBukkitPacketEvent) {}
}
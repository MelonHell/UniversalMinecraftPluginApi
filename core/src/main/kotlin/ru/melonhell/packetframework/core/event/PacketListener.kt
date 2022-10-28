package ru.melonhell.packetframework.core.event

import ru.melonhell.packetframework.core.wrappers.PluginWrapper

abstract class PacketListener(val pluginWrapper: PluginWrapper) {
    open fun onPacketSending(event: PfPacketEvent) {}
    open fun onPacketReceiving(event: PfPacketEvent) {}
}
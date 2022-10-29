package ru.melonhell.umpa.core.event

import ru.melonhell.umpa.core.wrappers.PluginWrapper

abstract class PacketListener(val pluginWrapper: PluginWrapper) {
    open fun onPacketSending(event: PfPacketEvent) {}
    open fun onPacketReceiving(event: PfPacketEvent) {}
}
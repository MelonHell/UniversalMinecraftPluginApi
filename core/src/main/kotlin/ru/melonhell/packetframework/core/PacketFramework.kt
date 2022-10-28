package ru.melonhell.packetframework.core

import ru.melonhell.packetframework.core.event.PacketListener
import ru.melonhell.packetframework.core.wrappers.Client

object PacketFramework : PacketFrameworkService {
    private var packetFrameworkService: PacketFrameworkService? = null
    override fun send(player: Client, packetWrapper: PacketWrapper) {
        packetFrameworkService!!.send(player, packetWrapper)
    }

    override fun addListener(listener: PacketListener) {
        packetFrameworkService!!.addListener(listener)
    }

    override fun removeListener(listener: PacketListener) {
        packetFrameworkService!!.removeListener(listener)
    }
}
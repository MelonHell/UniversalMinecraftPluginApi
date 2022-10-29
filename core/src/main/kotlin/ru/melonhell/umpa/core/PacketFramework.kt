package ru.melonhell.umpa.core

import ru.melonhell.umpa.core.event.PacketListener
import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer
import ru.melonhell.umpa.core.wrappers.UmpaPlayer

object PacketFramework : PacketFrameworkService {
    private lateinit var packetFrameworkService: PacketFrameworkService
    override fun send(player: UmpaPlayer, packetWrapper: UmpaPacketContainer) {
        packetFrameworkService.send(player, packetWrapper)
    }

    override fun addListener(listener: PacketListener) {
        packetFrameworkService.addListener(listener)
    }

    override fun removeListener(listener: PacketListener) {
        packetFrameworkService.removeListener(listener)
    }
}
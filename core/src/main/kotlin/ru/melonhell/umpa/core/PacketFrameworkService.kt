package ru.melonhell.umpa.core

import ru.melonhell.umpa.core.event.PacketListener
import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer
import ru.melonhell.umpa.core.wrappers.UmpaPlayer

interface PacketFrameworkService {
    fun send(player: UmpaPlayer, packetWrapper: UmpaPacketContainer)
    fun addListener(listener: PacketListener)
    fun removeListener(listener: PacketListener)
}
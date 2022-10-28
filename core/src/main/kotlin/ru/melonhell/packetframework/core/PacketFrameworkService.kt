package ru.melonhell.packetframework.core

import ru.melonhell.packetframework.core.event.PacketListener
import ru.melonhell.packetframework.core.wrappers.Client

interface PacketFrameworkService {
    fun send(player: Client, packetWrapper: PacketWrapper)
    fun addListener(listener: PacketListener)
    fun removeListener(listener: PacketListener)
}
package ru.melonhell.packetframework.core

import ru.melonhell.packetframework.core.event.PacketFrameworkListener
import ru.melonhell.packetframework.core.wrappers.Client

interface PacketFrameworkService {
    fun send(player: Client, packetWrapper: PacketWrapper)
    fun addListener(listener: PacketFrameworkListener)
    fun removeListener(listener: PacketFrameworkListener)
}
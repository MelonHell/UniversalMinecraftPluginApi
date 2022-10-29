package ru.melonhell.umpa.core

import ru.melonhell.umpa.core.event.PacketListener
import ru.melonhell.umpa.core.wrappers.Client

interface PacketFrameworkService {
    fun send(player: Client, packetWrapper: PacketWrapper)
    fun addListener(listener: PacketListener)
    fun removeListener(listener: PacketListener)
}
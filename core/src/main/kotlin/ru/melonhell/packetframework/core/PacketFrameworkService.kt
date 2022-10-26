package ru.melonhell.packetframework.core

import ru.melonhell.packetframework.core.event.PacketFrameworkListener
import ru.melonhell.packetframework.core.wrappers.PlayerWrapper

interface PacketFrameworkService {
    fun send(player: PlayerWrapper, packetWrapper: PacketWrapper)
    fun addListener(listener: PacketFrameworkListener)
    fun removeListener(listener: PacketFrameworkListener)
}
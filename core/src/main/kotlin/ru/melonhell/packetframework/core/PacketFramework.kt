package ru.melonhell.packetframework.core

object PacketFramework {
    var packetFrameworkService: PacketFrameworkService? = null

    @JvmStatic
    fun getService() : PacketFrameworkService {
        return packetFrameworkService!!
    }
}
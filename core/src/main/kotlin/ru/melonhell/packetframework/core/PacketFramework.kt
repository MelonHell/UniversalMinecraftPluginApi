package ru.melonhell.packetframework.core

object PacketFramework {
    private var packetFrameworkService: PacketFrameworkService? = null

    @JvmStatic
    fun getService() : PacketFrameworkService {
        return packetFrameworkService!!
    }
}
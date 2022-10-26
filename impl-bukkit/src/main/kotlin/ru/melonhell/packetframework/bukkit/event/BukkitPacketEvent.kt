package ru.melonhell.packetframework.bukkit.event

import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.bukkit.BukkitPacketFrameworkService
import ru.melonhell.packetframework.core.event.PfPacketEvent

class BukkitPacketEvent(
    private val packetContainer: PacketContainer,
    private val bukkitPacketFrameworkService: BukkitPacketFrameworkService
) : PfPacketEvent {

    private var edited = false

    override var canceled = false

    private var packetWrapper: PacketWrapper? = null

    override fun getPacketWrapper(): PacketWrapper {
        if (packetWrapper == null) packetWrapper = bukkitPacketFrameworkService.wrap(packetContainer)
        return packetWrapper!!.clone()
    }

    override fun setPacketWrapper(packetWrapper: PacketWrapper) {
        this.packetWrapper = packetWrapper.clone()
        edited = true
    }

    override fun isEdited(): Boolean {
        return edited
    }
}
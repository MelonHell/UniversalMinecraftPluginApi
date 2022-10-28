package ru.melonhell.packetframework.bukkit.event

import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.wrappers.BukkitClient
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.event.PfPacketEvent

class BukkitPacketEvent(
    private val client: BukkitClient,
    private val packetContainer: PacketContainer,
    private val packetType: Class<out PacketWrapper>,
    private val packetConverter: PacketConverter
) : PfPacketEvent {

    private var edited = false

    override var canceled = false

    private var packetWrapper: PacketWrapper? = null

    override fun getPacketWrapper(): PacketWrapper {
        if (packetWrapper == null) packetWrapper = packetConverter.wrap(packetContainer)
        return packetWrapper!!.clone()
    }

    override fun getPacketType(): Class<out PacketWrapper> {
        if (packetWrapper != null) packetWrapper!!::class.java
        return packetType
    }

    override fun setPacketWrapper(packetWrapper: PacketWrapper) {
        this.packetWrapper = packetWrapper.clone()
        edited = true
    }

    override fun getClient() = client

    override fun isEdited() = edited
}
package ru.melonhell.packetframework.bukkit.event

import com.comphenix.protocol.events.PacketContainer
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.bukkit.wrappers.BukkitClient
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.event.PfPacketEvent

class BukkitPacketEvent(
    override val client: BukkitClient,
    private val packetContainer: PacketContainer,
    private val originalPacketType: Class<out PacketWrapper>,
    private val packetConverter: PacketConverter
) : PfPacketEvent {
    private var packetWrapperPrivate: PacketWrapper? = null
    override var edited = false
        private set

    override var canceled = false
    override var packetWrapper: PacketWrapper
        get() {
            if (packetWrapperPrivate == null) packetWrapperPrivate = packetConverter.wrap(packetContainer)
            return packetWrapperPrivate!!.clone()
        }
        set(value) {
            this.packetWrapperPrivate = value.clone()
            edited = true
        }
    override val packetType: Class<out PacketWrapper>
        get() {
            if (packetWrapperPrivate != null) packetWrapperPrivate!!::class.java
            return originalPacketType
        }
}
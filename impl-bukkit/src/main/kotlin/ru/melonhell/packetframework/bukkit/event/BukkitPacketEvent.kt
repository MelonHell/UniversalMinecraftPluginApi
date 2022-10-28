package ru.melonhell.packetframework.bukkit.event

import ru.melonhell.packetframework.bukkit.wrappers.BukkitClient
import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.event.PfPacketEvent
import java.util.function.Supplier

class BukkitPacketEvent(
    override val client: BukkitClient,
    private val originalPacketType: Class<out PacketWrapper>,
    private val wrapperSupplier: Supplier<PacketWrapper>
) : PfPacketEvent {
    private var packetWrapperPrivate: PacketWrapper? = null
    override var edited = false
        private set

    override var canceled = false
    override var packetWrapper: PacketWrapper
        get() {
            if (packetWrapperPrivate == null) packetWrapperPrivate = wrapperSupplier.get()
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
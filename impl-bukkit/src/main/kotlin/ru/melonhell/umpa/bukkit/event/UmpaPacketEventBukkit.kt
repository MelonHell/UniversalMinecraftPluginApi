package ru.melonhell.umpa.bukkit.event

import org.bukkit.entity.Player
import ru.melonhell.umpa.bukkit.utils.LazyUtils.currentValue
import ru.melonhell.umpa.bukkit.wrappers.UmpaPlayerBukkit
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.event.events.UmpaPacketEvent
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

class UmpaPacketEventBukkit(
    override val bukkitPlayer: Player,
    private var lazyPacket: Lazy<UmpaPacket>,
    private val originalPacketType: UmpaPacketType
) : UmpaPacketEvent, UmpaPlayerEventBukkit {
    override var edited = false
        private set

    override var canceled = false
    override val player = UmpaPlayerBukkit(bukkitPlayer)
    override var packetWrapper: UmpaPacket
        get() = lazyPacket.value.clone()
        set(value) {
            lazyPacket = lazyOf(value.clone())
            edited = true
        }
    override val packetType get() = lazyPacket.currentValue?.packetType ?: originalPacketType
}
package ru.melonhell.umpa.bukkit.event

import org.bukkit.entity.Player
import ru.melonhell.umpa.bukkit.wrappers.UmpaPlayerBukkit
import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.event.events.UmpaPacketEvent
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import java.util.function.Supplier

class UmpaPacketEventBukkit(
    override val bukkitPlayer: Player,
    private val wrapperSupplier: Supplier<UmpaPacket>,
    private val originalPacketType: UmpaPacketType
) : UmpaPacketEvent, UmpaPlayerEventBukkit {
    override var edited = false
        private set

    override var canceled = false
    override val player = UmpaPlayerBukkit(bukkitPlayer)

    private var _packetWrapper: UmpaPacket? = null
    override var packetWrapper: UmpaPacket
        get() {
            _packetWrapper ?: run { _packetWrapper = wrapperSupplier.get() }
            return _packetWrapper!!.clone()
        }
        set(value) {
            _packetWrapper = value.clone()
            edited = true
        }
    override val packetType get() = _packetWrapper?.packetType ?: originalPacketType
}
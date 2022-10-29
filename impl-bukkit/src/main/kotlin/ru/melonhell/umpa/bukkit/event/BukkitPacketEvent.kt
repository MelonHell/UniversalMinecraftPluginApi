package ru.melonhell.umpa.bukkit.event

import org.bukkit.entity.Player
import ru.melonhell.umpa.bukkit.wrappers.BukkitClient
import java.util.function.Supplier

class BukkitPacketEvent(
    override val player: Player,
    private val wrapperSupplier: Supplier<ru.melonhell.umpa.core.PacketWrapper>,
    private val originalPacketType: Class<out ru.melonhell.umpa.core.PacketWrapper>
) : IBukkitPacketEvent {
    override var edited = false
        private set

    override var canceled = false
    override val client = BukkitClient(player)

    private var _packetWrapper: ru.melonhell.umpa.core.PacketWrapper? = null
    override var packetWrapper: ru.melonhell.umpa.core.PacketWrapper
        get() {
            _packetWrapper ?: run { _packetWrapper = wrapperSupplier.get() }
            return _packetWrapper!!.clone()
        }
        set(value) {
            _packetWrapper = value.clone()
            edited = true
        }
    override val packetType get() = _packetWrapper?.javaClass ?: originalPacketType
}
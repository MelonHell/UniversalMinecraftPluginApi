package ru.melonhell.packetframework.bukkit.event

import org.bukkit.entity.Player
import ru.melonhell.packetframework.bukkit.wrappers.BukkitClient
import ru.melonhell.packetframework.core.PacketWrapper
import java.util.function.Supplier

class BukkitPacketEvent(
    override val player: Player,
    private val wrapperSupplier: Supplier<PacketWrapper>,
    private val originalPacketType: Class<out PacketWrapper>
) : IBukkitPacketEvent {
    override var edited = false
        private set

    override var canceled = false
    override val client = BukkitClient(player)

    private var _packetWrapper: PacketWrapper? = null
    override var packetWrapper: PacketWrapper
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
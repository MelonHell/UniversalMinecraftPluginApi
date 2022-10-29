package ru.melonhell.umpa.bukkit.event

import org.bukkit.entity.Player
import ru.melonhell.umpa.bukkit.wrappers.BukkitUmpaPlayer
import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer
import java.util.function.Supplier

class BukkitPacketEvent(
    override val player: Player,
    private val wrapperSupplier: Supplier<UmpaPacketContainer>,
    private val originalPacketType: Class<out UmpaPacketContainer>
) : IBukkitPacketEvent {
    override var edited = false
        private set

    override var canceled = false
    override val umpaPlayer = BukkitUmpaPlayer(player)

    private var _packetWrapper: UmpaPacketContainer? = null
    override var packetWrapper: UmpaPacketContainer
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
package ru.melonhell.packetframework.core.protocol.game.clientbound

import ru.melonhell.packetframework.core.PacketWrapper

data class CbPlayerAbilitiesPacketWrapper(
    var invulnerable: Boolean = false,
    var isFlying: Boolean = false,
    var canFly: Boolean = false,
    var instabuild: Boolean = false,
    var flyingSpeed: Float = 0.5f,
    var fov: Float = 0.1f
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }

    fun setZoom(zoom: Double) {
        fov = (zoom / (20.0 - 10.0 * zoom)).toFloat()
    }

    fun getZoom() : Double {
        return (20.0 * fov / (1.0 + 10.0 * fov))
    }
}
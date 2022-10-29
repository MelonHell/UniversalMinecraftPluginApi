package ru.melonhell.umpa.core.packet.containers.clientbound

import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer

data class UmpaCbPlayerAbilitiesPacket(
    var invulnerable: Boolean = false,
    var isFlying: Boolean = false,
    var canFly: Boolean = false,
    var instabuild: Boolean = false,
    var flyingSpeed: Float = 0.5f,
    var fov: Float = 0.1f
) : UmpaPacketContainer {
    override fun clone(): UmpaPacketContainer {
        return this.copy()
    }

    fun setZoom(zoom: Double) {
        fov = (zoom / (20.0 - 10.0 * zoom)).toFloat()
    }

    fun getZoom(): Double {
        return (20.0 * fov / (1.0 + 10.0 * fov))
    }
}
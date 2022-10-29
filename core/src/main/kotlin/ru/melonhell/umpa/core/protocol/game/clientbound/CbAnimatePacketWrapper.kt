package ru.melonhell.umpa.core.protocol.game.clientbound

data class CbAnimatePacketWrapper(
    var entityId: Int,
    var action: ru.melonhell.umpa.core.enums.EntityAnimation
) : ru.melonhell.umpa.core.PacketWrapper {
    override fun clone(): ru.melonhell.umpa.core.PacketWrapper {
        return this.copy()
    }
}
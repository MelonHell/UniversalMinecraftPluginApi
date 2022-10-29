package ru.melonhell.umpa.core.protocol.game.serverbound

data class SbPlayerInputPacketWrapper(
    var sideways: Float,
    var forward: Float,
    var jumping: Boolean,
    var sneaking: Boolean
) : ru.melonhell.umpa.core.PacketWrapper {
    override fun clone(): ru.melonhell.umpa.core.PacketWrapper {
        return this.copy()
    }
}

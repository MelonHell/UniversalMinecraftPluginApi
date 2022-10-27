package ru.melonhell.packetframework.core.protocol.game.serverbound

import ru.melonhell.packetframework.core.PacketWrapper

data class ServerboundPlayerInputPacketWrapper(
    var sideways: Float,
    var forward: Float,
    var jumping: Boolean,
    var sneaking: Boolean
) : PacketWrapper {
    override fun clone(): PacketWrapper {
        return this.copy()
    }
}

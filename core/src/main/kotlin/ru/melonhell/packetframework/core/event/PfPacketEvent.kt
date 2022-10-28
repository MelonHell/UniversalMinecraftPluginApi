package ru.melonhell.packetframework.core.event

import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.wrappers.Client

interface PfPacketEvent {
    var canceled: Boolean
    fun isEdited(): Boolean
    fun getPacketWrapper(): PacketWrapper
    fun getPacketType(): Class<out PacketWrapper>
    fun setPacketWrapper(packetWrapper: PacketWrapper)

    fun getClient() : Client
}
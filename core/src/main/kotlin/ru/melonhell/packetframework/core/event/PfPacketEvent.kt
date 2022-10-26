package ru.melonhell.packetframework.core.event

import ru.melonhell.packetframework.core.PacketWrapper

interface PfPacketEvent {
    var canceled: Boolean
    fun isEdited() : Boolean
    fun getPacketWrapper(): PacketWrapper
    fun setPacketWrapper(packetWrapper: PacketWrapper)
}
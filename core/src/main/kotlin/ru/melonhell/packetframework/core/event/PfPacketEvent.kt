package ru.melonhell.packetframework.core.event

import ru.melonhell.packetframework.core.PacketWrapper
import ru.melonhell.packetframework.core.wrappers.Client

interface PfPacketEvent {
    val client: Client
    var packetWrapper: PacketWrapper
    val packetType: Class<out PacketWrapper>
    var canceled: Boolean
    val edited: Boolean
}
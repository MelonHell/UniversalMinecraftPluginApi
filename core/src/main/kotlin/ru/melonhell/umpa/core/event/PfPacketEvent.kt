package ru.melonhell.umpa.core.event

import ru.melonhell.umpa.core.wrappers.Client

interface PfPacketEvent {
    val client: Client
    var packetWrapper: ru.melonhell.umpa.core.PacketWrapper
    val packetType: Class<out ru.melonhell.umpa.core.PacketWrapper>
    var canceled: Boolean
    val edited: Boolean
}
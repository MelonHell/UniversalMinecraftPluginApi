package ru.melonhell.umpa.core.event

import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.wrappers.UmpaPlayer

interface UmpaPacketEvent {
    val umpaPlayer: UmpaPlayer
    var packetWrapper: UmpaPacket
    val packetType: Class<out UmpaPacket>
    var canceled: Boolean
    val edited: Boolean
}
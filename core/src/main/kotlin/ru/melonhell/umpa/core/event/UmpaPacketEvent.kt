package ru.melonhell.umpa.core.event

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.wrappers.UmpaPlayer

interface UmpaPacketEvent {
    val player: UmpaPlayer
    var packetWrapper: UmpaPacket
    val packetType: UmpaPacketType
    var canceled: Boolean
    val edited: Boolean
}
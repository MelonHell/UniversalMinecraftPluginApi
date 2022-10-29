package ru.melonhell.umpa.core.event

import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer
import ru.melonhell.umpa.core.wrappers.UmpaPlayer

interface UmpaPacketEvent {
    val umpaPlayer: UmpaPlayer
    var packetWrapper: UmpaPacketContainer
    val packetType: Class<out UmpaPacketContainer>
    var canceled: Boolean
    val edited: Boolean
}
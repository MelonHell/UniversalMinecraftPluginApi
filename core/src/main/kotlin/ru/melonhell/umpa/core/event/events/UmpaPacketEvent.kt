package ru.melonhell.umpa.core.event.events

import ru.melonhell.umpa.core.enums.UmpaPacketType
import ru.melonhell.umpa.core.event.trait.UmpaCancelableEvent
import ru.melonhell.umpa.core.event.trait.UmpaPlayerEvent
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

interface UmpaPacketEvent : UmpaPlayerEvent, UmpaCancelableEvent {
    var packetWrapper: UmpaPacket
    val packetType: UmpaPacketType
    val edited: Boolean
}
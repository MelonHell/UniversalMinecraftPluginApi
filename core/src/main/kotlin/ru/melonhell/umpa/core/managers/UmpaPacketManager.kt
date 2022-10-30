package ru.melonhell.umpa.core.managers

import ru.melonhell.umpa.core.packet.containers.UmpaPacket
import ru.melonhell.umpa.core.wrappers.UmpaPlayer

interface UmpaPacketManager {
    fun send(player: UmpaPlayer, packetWrapper: UmpaPacket)
}
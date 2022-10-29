package ru.melonhell.umpa.core.packet.containers

import ru.melonhell.umpa.core.enums.UmpaPacketType

abstract class UmpaPacket(val packetType: UmpaPacketType) : Cloneable {
    public override fun clone(): UmpaPacket {
        return super.clone() as UmpaPacket
    }
}
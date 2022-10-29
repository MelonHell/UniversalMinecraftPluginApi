package ru.melonhell.umpa.core.packet.containers

interface UmpaPacket : Cloneable {
    public override fun clone(): UmpaPacket {
        return super.clone() as UmpaPacket
    }
}
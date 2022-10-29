package ru.melonhell.umpa.core.packet.containers

interface UmpaPacketContainer : Cloneable {
    public override fun clone(): UmpaPacketContainer {
        return super.clone() as UmpaPacketContainer
    }
}
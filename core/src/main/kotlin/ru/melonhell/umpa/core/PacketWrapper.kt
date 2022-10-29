package ru.melonhell.umpa.core

interface PacketWrapper : Cloneable {
    public override fun clone(): PacketWrapper {
        return super.clone() as PacketWrapper
    }
}
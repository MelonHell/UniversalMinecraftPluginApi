package ru.melonhell.packetframework.core

interface PacketWrapper : Cloneable {
    public override fun clone(): PacketWrapper
}
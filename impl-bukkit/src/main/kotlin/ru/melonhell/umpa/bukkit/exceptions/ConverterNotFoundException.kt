package ru.melonhell.umpa.bukkit.exceptions

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.utility.MinecraftVersion
import ru.melonhell.umpa.core.packet.containers.UmpaPacketContainer

class ConverterNotFoundException : RuntimeException {
    constructor(wrapper: UmpaPacketContainer) :
            super("converter not found for wrapper ${wrapper::class.simpleName} for version ${MinecraftVersion.getCurrentVersion().version}")

    constructor(type: PacketType) :
            super("converter not found for ProtocolLib type ${type.name()} for version ${MinecraftVersion.getCurrentVersion().version}")
}
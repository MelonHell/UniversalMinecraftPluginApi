package ru.melonhell.packetframework.bukkit.exceptions

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.utility.MinecraftVersion
import ru.melonhell.packetframework.core.PacketWrapper

class ConverterNotFoundException : RuntimeException {
    constructor(wrapper: PacketWrapper) :
            super("converter not found for wrapper ${wrapper::class.simpleName} for version ${MinecraftVersion.getCurrentVersion().version}")

    constructor(type: PacketType) :
            super("converter not found for ProtocolLib type ${type.name()} for version ${MinecraftVersion.getCurrentVersion().version}")
}
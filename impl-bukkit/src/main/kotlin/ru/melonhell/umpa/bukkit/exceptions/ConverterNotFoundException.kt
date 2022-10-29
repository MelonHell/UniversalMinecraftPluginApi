package ru.melonhell.umpa.bukkit.exceptions

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.utility.MinecraftVersion

class ConverterNotFoundException : RuntimeException {
    constructor(wrapper: ru.melonhell.umpa.core.PacketWrapper) :
            super("converter not found for wrapper ${wrapper::class.simpleName} for version ${MinecraftVersion.getCurrentVersion().version}")

    constructor(type: PacketType) :
            super("converter not found for ProtocolLib type ${type.name()} for version ${MinecraftVersion.getCurrentVersion().version}")
}
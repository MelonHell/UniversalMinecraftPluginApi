package ru.melonhell.umpa.bukkit.exceptions

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.utility.MinecraftVersion
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

class UmpaConverterNotFoundException : UmpaRuntimeException {
    constructor(wrapper: UmpaPacket) :
            super("converter not found for wrapper ${wrapper::class.simpleName} for version ${MinecraftVersion.getCurrentVersion().version}")

    constructor(type: PacketType) :
            super("converter not found for ProtocolLib type ${type.name()} for version ${MinecraftVersion.getCurrentVersion().version}")
}
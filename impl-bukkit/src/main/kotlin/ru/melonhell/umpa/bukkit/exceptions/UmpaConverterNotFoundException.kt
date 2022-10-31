package ru.melonhell.umpa.bukkit.exceptions

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.utility.MinecraftVersion
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

class UmpaConverterNotFoundException : UmpaRuntimeException {
    constructor(wrapper: UmpaPacket) :
            super("Converter for UmpaPacketType.${wrapper.packetType.name} for version ${MinecraftVersion.getCurrentVersion().version} not found")

    constructor(type: PacketType) :
            super("Converter for ProtocolLib PacketType.${type.name()} for version ${MinecraftVersion.getCurrentVersion().version} not found")
}
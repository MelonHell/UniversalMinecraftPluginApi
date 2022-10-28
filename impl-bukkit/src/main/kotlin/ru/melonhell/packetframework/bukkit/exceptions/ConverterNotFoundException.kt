package ru.melonhell.packetframework.bukkit.exceptions

import com.comphenix.protocol.PacketType
import ru.melonhell.packetframework.core.PacketWrapper

class ConverterNotFoundException : RuntimeException {
    constructor(wrapper: PacketWrapper) : super("converter not found for wrapper ${wrapper::class.simpleName}}")
    constructor(type: PacketType) : super("converter not found for ProtocolLib type ${type.name()}")
}
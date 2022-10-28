package ru.melonhell.packetframework.bukkit.exceptions

import com.comphenix.protocol.PacketType
import ru.melonhell.packetframework.bukkit.converter.PacketConverter
import ru.melonhell.packetframework.core.PacketWrapper

class WrongConverterException : RuntimeException {
    constructor(
        wrapper: PacketWrapper,
        converter: PacketConverter
    ) : super("wrapperClass: ${wrapper::class.simpleName}, converterClass: ${converter::class.simpleName}")

    constructor(
        type: PacketType,
        converter: PacketConverter
    ) : super("packetType: ${type.name()}, converterClass: ${converter::class.simpleName}")
}
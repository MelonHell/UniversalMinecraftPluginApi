package ru.melonhell.umpa.bukkit.exceptions

import com.comphenix.protocol.PacketType
import ru.melonhell.umpa.bukkit.converter.PacketConverter

class WrongConverterException : RuntimeException {
    constructor(
        wrapper: ru.melonhell.umpa.core.PacketWrapper,
        converter: PacketConverter
    ) : super("wrapperClass: ${wrapper::class.simpleName}, converterClass: ${converter::class.simpleName}")

    constructor(
        type: PacketType,
        converter: PacketConverter
    ) : super("packetType: ${type.name()}, converterClass: ${converter::class.simpleName}")
}
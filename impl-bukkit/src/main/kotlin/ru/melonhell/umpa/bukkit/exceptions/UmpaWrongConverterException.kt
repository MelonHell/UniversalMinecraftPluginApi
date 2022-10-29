package ru.melonhell.umpa.bukkit.exceptions

import com.comphenix.protocol.PacketType
import ru.melonhell.umpa.bukkit.packet.protocollib.converter.PacketConverter
import ru.melonhell.umpa.core.packet.containers.UmpaPacket

class UmpaWrongConverterException : UmpaRuntimeException {
    constructor(
        wrapper: UmpaPacket,
        converter: PacketConverter
    ) : super("wrapperClass: ${wrapper::class.simpleName}, converterClass: ${converter::class.simpleName}")

    constructor(
        type: PacketType,
        converter: PacketConverter
    ) : super("packetType: ${type.name()}, converterClass: ${converter::class.simpleName}")
}
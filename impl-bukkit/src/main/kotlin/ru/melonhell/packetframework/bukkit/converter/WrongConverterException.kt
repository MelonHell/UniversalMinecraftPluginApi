package ru.melonhell.packetframework.bukkit.converter

import ru.melonhell.packetframework.core.PacketWrapper
import kotlin.reflect.KClass

class WrongConverterException(
    wrapperClass: KClass<out PacketWrapper>,
    converterClass: KClass<out PacketConverter>
) : RuntimeException("wrapperClass: ${wrapperClass.simpleName}, converterClass: ${converterClass.simpleName}") {
}
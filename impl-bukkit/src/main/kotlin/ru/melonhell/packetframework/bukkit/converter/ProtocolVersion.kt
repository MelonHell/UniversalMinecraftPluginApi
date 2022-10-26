package ru.melonhell.packetframework.bukkit.converter

import ru.melonhell.packetframework.core.PacketWrapper
import kotlin.reflect.KClass

annotation class ProtocolVersion(val minVersion: String, val maxVersion: String, val wrapper: KClass<out PacketWrapper>)

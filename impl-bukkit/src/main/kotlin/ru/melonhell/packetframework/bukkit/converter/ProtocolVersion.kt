package ru.melonhell.packetframework.bukkit.converter

import com.github.matfax.klassindex.IndexAnnotated

@IndexAnnotated
annotation class ProtocolVersion(val minVersion: String, val maxVersion: String)

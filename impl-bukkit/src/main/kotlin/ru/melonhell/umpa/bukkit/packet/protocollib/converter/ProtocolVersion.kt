package ru.melonhell.umpa.bukkit.packet.protocollib.converter

import com.github.matfax.klassindex.IndexAnnotated

@IndexAnnotated
annotation class ProtocolVersion(val minVersion: String, val maxVersion: String)

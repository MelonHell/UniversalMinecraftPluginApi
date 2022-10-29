package ru.melonhell.umpa.bukkit.converter

import com.github.matfax.klassindex.IndexAnnotated

@IndexAnnotated
annotation class ProtocolVersion(val minVersion: String, val maxVersion: String)

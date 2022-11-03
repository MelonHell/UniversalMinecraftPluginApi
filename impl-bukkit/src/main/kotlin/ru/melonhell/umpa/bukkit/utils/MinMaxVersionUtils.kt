package ru.melonhell.umpa.bukkit.utils

import com.comphenix.protocol.utility.MinecraftVersion
import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion

object MinMaxVersionUtils {
    fun MinMaxMinecraftVersion.isCurrentVersionInRange(): Boolean {
        val minVersion = MinecraftVersion(this.minVersion)
        val maxVersion = MinecraftVersion(this.maxVersion.replace("latest", "1.99"))
        return MinecraftVersion.getCurrentVersion() in minVersion..maxVersion
    }
}
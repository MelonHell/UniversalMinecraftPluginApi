package ru.melonhell.umpa.bukkit.utils

import com.comphenix.protocol.utility.MinecraftVersion
import com.github.matfax.klassindex.IndexAnnotated

@IndexAnnotated
annotation class MinMaxMinecraftVersion(val minVersion: String, val maxVersion: String) {
    companion object {
        fun MinMaxMinecraftVersion.isCurrentVersionInRange(): Boolean {
            val minVersion = MinecraftVersion(this.minVersion)
            val maxVersion = MinecraftVersion(this.maxVersion.replace("latest", "1.99"))
            return MinecraftVersion.getCurrentVersion() in minVersion..maxVersion
        }
    }
}
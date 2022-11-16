package ru.melonhell.umpa.bukkit.utils

object LazyUtils {
    @JvmStatic
    val <T> Lazy<T>.currentValue: T?
        get() = if (this.isInitialized()) this.value else null
}
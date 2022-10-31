package ru.melonhell.umpa.core.enums.keyed

import net.kyori.adventure.key.Key

interface UmpaKeyed {
    val key: Key

    interface Companion<T> {
        fun fromKey(key: String): T?
        fun fromKey(key: Key): T?
    }
}
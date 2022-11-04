package ru.melonhell.umpa.core.wrappers

import java.util.*

abstract class UmpaRawEntityMetadata : UmpaWrapper() {
    abstract fun <T> readValue(id: Int, clazz: Class<T>): T?
    abstract fun <T> writeValue(id: Int, value: T?, clazz: Class<T>)
    abstract fun <T> readOptional(id: Int, clazz: Class<T>): Optional<T>?
    abstract fun <T> writeOptional(id: Int, value: Optional<T>?, clazz: Class<T>)
    abstract fun readFlag(id: Int, flagId: Int): Boolean?
    abstract fun writeFlag(id: Int, flagId: Int, value: Boolean?)
}
package ru.melonhell.umpa.core.wrappers

import java.util.*

abstract class UmpaRawEntityMetadata : UmpaWrapper() {
    abstract fun <T> setOptional(id: Int, value: Optional<T>?, clazz: Class<T>)
    abstract fun <T> getOptional(id: Int, clazz: Class<T>): Optional<T>?
    abstract fun setValue(id: Int, value: Any?)
    abstract fun <T> getValue(id: Int, clazz: Class<T>): T?
    abstract fun getFlag(id: Int, flagId: Int): Boolean?
    abstract fun setFlag(id: Int, flagId: Int, value: Boolean?)
}
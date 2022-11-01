package ru.melonhell.umpa.core.wrappers

abstract class UmpaWrapper {
    abstract val handle: Any
    override fun equals(other: Any?): Boolean {
        if (other !is UmpaWrapper) return false
        return handle == other.handle
    }

    override fun hashCode(): Int {
        return handle.hashCode()
    }
}
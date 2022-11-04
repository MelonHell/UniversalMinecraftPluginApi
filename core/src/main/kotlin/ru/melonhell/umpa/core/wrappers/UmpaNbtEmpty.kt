package ru.melonhell.umpa.core.wrappers

class UmpaNbtEmpty : UmpaNbt() {
    override val handle: Any
        get() = 0
}
package ru.melonhell.umpa.core.wrappers

import java.util.*

abstract class UmpaPlayer : UmpaWrapper() {
    abstract val name: String
    abstract val uuid: UUID
}
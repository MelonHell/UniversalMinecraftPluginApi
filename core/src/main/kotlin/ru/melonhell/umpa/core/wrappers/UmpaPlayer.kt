package ru.melonhell.umpa.core.wrappers

import ru.melonhell.umpa.core.utils.UmpaEntityLocation
import java.util.*

abstract class UmpaPlayer : UmpaWrapper() {
    abstract val name: String
    abstract val uuid: UUID
    abstract val location: UmpaEntityLocation
}
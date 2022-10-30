package ru.melonhell.umpa.core.wrappers

import java.util.UUID

interface UmpaPlayer {
    val handle: Any
    val name: String
    val uuid: UUID
}
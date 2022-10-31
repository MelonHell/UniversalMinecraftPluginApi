package ru.melonhell.umpa.core.managers

import ru.melonhell.umpa.core.wrappers.UmpaPlayer
import java.util.*

interface UmpaPlayerManager {
    fun player(name: String): UmpaPlayer?
    fun player(uuid: UUID): UmpaPlayer?
    fun player(player: Any): UmpaPlayer
}
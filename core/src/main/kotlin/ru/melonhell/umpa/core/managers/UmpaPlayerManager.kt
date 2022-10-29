package ru.melonhell.umpa.core.managers

import ru.melonhell.umpa.core.wrappers.UmpaPlayer
import java.util.UUID

interface UmpaPlayerManager {
    fun getPlayer(name: String): UmpaPlayer?
    fun getPlayer(uuid: UUID): UmpaPlayer?
    fun getPlayer(player: Any): UmpaPlayer
}
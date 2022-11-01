package ru.melonhell.umpa.bukkit.wrappers

import org.bukkit.entity.Player
import ru.melonhell.umpa.bukkit.utils.converter.BukkitConverter.umpa
import ru.melonhell.umpa.core.utils.UmpaEntityLocation
import ru.melonhell.umpa.core.wrappers.UmpaPlayer
import java.util.*

class UmpaPlayerBukkit(override val handle: Player) : UmpaPlayer() {
    override val name: String
        get() = handle.name
    override val uuid: UUID
        get() = handle.uniqueId
    override val location: UmpaEntityLocation
        get() = handle.location.umpa()

    override fun toString(): String {
        return "UmpaPlayerBukkit($name)"
    }
}
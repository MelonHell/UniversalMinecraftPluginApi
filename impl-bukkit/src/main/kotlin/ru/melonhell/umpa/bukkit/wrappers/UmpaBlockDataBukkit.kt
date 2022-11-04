package ru.melonhell.umpa.bukkit.wrappers

import org.bukkit.block.data.BlockData
import ru.melonhell.umpa.bukkit.utils.NmsUtils
import ru.melonhell.umpa.bukkit.utils.NmsUtils.getId
import ru.melonhell.umpa.core.wrappers.UmpaBlockData

class UmpaBlockDataBukkit(override val handle: BlockData) : UmpaBlockData() {
    val id = handle.getId()

    override fun toString(): String {
        return "UmpaBlockDataBukkit(id=$id, material=${handle.material.name})"
    }
}
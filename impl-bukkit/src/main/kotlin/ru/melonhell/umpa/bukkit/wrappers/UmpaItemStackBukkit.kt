package ru.melonhell.umpa.bukkit.wrappers

import org.bukkit.inventory.ItemStack
import ru.melonhell.umpa.bukkit.utils.BukkitEnumConverter
import ru.melonhell.umpa.core.wrappers.UmpaItemStack

class UmpaItemStackBukkit(override val handle: ItemStack) : UmpaItemStack() {

    override val type get() = BukkitEnumConverter.fromBukkit(handle.type)

    override val amount get() = handle.amount
}
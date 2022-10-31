package ru.melonhell.umpa.bukkit.wrappers

import org.bukkit.inventory.ItemStack
import ru.melonhell.umpa.bukkit.utils.converter.BukkitEnumConverter
import ru.melonhell.umpa.bukkit.utils.converter.BukkitEnumConverter.umpa
import ru.melonhell.umpa.core.wrappers.UmpaItemStack

class UmpaItemStackBukkit(override val handle: ItemStack) : UmpaItemStack() {

    override val type get() = handle.type.umpa()

    override val amount get() = handle.amount
}
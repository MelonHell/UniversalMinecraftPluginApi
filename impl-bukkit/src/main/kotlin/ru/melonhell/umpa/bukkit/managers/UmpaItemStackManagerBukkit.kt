package ru.melonhell.umpa.bukkit.managers

import org.bukkit.inventory.ItemStack
import ru.melonhell.umpa.bukkit.utils.BukkitEnumConverter
import ru.melonhell.umpa.bukkit.wrappers.UmpaItemStackBukkit
import ru.melonhell.umpa.core.enums.keyed.UmpaMaterial
import ru.melonhell.umpa.core.managers.UmpaItemStackManager
import ru.melonhell.umpa.core.wrappers.UmpaItemStack

class UmpaItemStackManagerBukkit : UmpaItemStackManager {
    override fun itemStack(material: UmpaMaterial, amount: Int): UmpaItemStack {
        return UmpaItemStackBukkit(ItemStack(BukkitEnumConverter.toBukkit(material), amount))
    }

    override fun itemStack(handle: Any): UmpaItemStack {
        return UmpaItemStackBukkit(handle as ItemStack)
    }
}
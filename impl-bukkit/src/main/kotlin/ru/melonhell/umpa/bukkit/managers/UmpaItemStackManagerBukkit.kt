package ru.melonhell.umpa.bukkit.managers

import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import ru.melonhell.umpa.bukkit.utils.converter.BukkitEnumConverter.bukkit
import ru.melonhell.umpa.bukkit.wrappers.UmpaItemStackBukkit
import ru.melonhell.umpa.core.enums.keyed.UmpaMaterial
import ru.melonhell.umpa.core.managers.UmpaItemStackManager
import ru.melonhell.umpa.core.wrappers.UmpaItemStack

class UmpaItemStackManagerBukkit : UmpaItemStackManager {
    override fun itemStack(material: UmpaMaterial, amount: Int): UmpaItemStack {
        return itemStack(material.bukkit(), amount)
    }

    @JvmOverloads
    fun itemStack(material: Material, amount: Int = 1): UmpaItemStack {
        return UmpaItemStackBukkit(ItemStack(material, amount))
    }

    override fun itemStack(handle: Any): UmpaItemStack {
        return UmpaItemStackBukkit(handle as ItemStack)
    }
}
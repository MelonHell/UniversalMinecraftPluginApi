package ru.melonhell.umpa.core.managers

import ru.melonhell.umpa.core.enums.keyed.UmpaMaterial
import ru.melonhell.umpa.core.wrappers.UmpaItemStack

interface UmpaItemStackManager {
    fun itemStack(material: UmpaMaterial, amount: Int): UmpaItemStack
    fun itemStack(material: UmpaMaterial) = itemStack(material, 1)
    fun itemStack(handle: Any): UmpaItemStack
}
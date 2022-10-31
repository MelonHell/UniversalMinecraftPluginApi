package ru.melonhell.umpa.core.wrappers

import ru.melonhell.umpa.core.enums.keyed.UmpaMaterial

abstract class UmpaItemStack : UmpaWrapper() {
    abstract val type: UmpaMaterial
    abstract val amount: Int
}
package ru.melonhell.umpa.core.data.entitymeta.meta.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractVillagerMetadata
import ru.melonhell.umpa.core.utils.UmpaVillagerData

open class UmpaVillagerMetadata(
    var villagerData: UmpaVillagerData = UmpaVillagerData()
) : UmpaAbstractVillagerMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaVillagerMetadata {
        return super.clone() as UmpaVillagerMetadata
    }

    companion object {
        private val empty = UmpaVillagerMetadata()
    }
}

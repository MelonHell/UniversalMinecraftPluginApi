package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.utils.UmpaVillagerData

open class UmpaZombieVillagerMetadata(
    var converting: Boolean = false,
    var villagerData: UmpaVillagerData = UmpaVillagerData()
) : UmpaZombieMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaZombieVillagerMetadata {
        return super.clone() as UmpaZombieVillagerMetadata
    }

    companion object {
        private val empty = UmpaZombieVillagerMetadata()
    }
}

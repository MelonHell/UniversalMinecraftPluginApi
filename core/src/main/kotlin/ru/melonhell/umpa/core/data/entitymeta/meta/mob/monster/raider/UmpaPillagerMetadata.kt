package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.raider

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractIllagerMetadata

open class UmpaPillagerMetadata(
    var chargingCrossbow: Boolean = false
) : UmpaAbstractIllagerMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaPillagerMetadata {
        return super.clone() as UmpaPillagerMetadata
    }

    companion object {
        private val empty = UmpaPillagerMetadata()
    }
}

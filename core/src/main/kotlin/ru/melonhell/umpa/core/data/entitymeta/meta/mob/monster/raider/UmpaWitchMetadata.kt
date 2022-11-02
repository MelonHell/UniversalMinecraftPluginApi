package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.raider

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaRaiderMetadata

open class UmpaWitchMetadata(
    var usingItem: Boolean = false
) : UmpaRaiderMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaWitchMetadata {
        return super.clone() as UmpaWitchMetadata
    }

    companion object {
        private val empty = UmpaWitchMetadata()
    }
}

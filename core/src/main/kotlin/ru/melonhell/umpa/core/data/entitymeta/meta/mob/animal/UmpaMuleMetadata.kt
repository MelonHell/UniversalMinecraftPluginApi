package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractChestedHorseMetadata

open class UmpaMuleMetadata : UmpaAbstractChestedHorseMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaMuleMetadata {
        return super.clone() as UmpaMuleMetadata
    }

    companion object {
        private val empty = UmpaMuleMetadata()
    }
}

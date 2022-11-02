package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractHorseMetadata

open class UmpaSkeletonHorseMetadata : UmpaAbstractHorseMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaSkeletonHorseMetadata {
        return super.clone() as UmpaSkeletonHorseMetadata
    }

    companion object {
        private val empty = UmpaSkeletonHorseMetadata()
    }
}

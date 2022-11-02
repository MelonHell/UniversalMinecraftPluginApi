package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaWaterAnimalMetadata

open class UmpaSquidMetadata : UmpaWaterAnimalMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaSquidMetadata {
        return super.clone() as UmpaSquidMetadata
    }

    companion object {
        private val empty = UmpaSquidMetadata()
    }
}

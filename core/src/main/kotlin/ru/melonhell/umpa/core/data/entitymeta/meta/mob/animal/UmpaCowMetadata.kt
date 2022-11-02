package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata

open class UmpaCowMetadata : UmpaAnimalMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaCowMetadata {
        return super.clone() as UmpaCowMetadata
    }

    companion object {
        private val empty = UmpaCowMetadata()
    }
}

package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata

open class UmpaPolarBearMetadata(
    var standing: Boolean = false
) : UmpaAnimalMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaPolarBearMetadata {
        return super.clone() as UmpaPolarBearMetadata
    }

    companion object {
        private val empty = UmpaPolarBearMetadata()
    }
}

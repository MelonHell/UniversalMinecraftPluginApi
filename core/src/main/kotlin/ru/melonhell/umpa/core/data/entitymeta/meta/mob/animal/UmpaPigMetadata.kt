package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata

open class UmpaPigMetadata(
    var hasSaddle: Boolean = false,
    var boostTime: Int = 0
) : UmpaAnimalMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaPigMetadata {
        return super.clone() as UmpaPigMetadata
    }

    companion object {
        private val empty = UmpaPigMetadata()
    }
}

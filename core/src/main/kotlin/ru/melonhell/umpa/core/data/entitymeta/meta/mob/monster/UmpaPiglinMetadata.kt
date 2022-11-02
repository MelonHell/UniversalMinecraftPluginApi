package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractPiglinMetadata

open class UmpaPiglinMetadata(
    var baby: Boolean = false,
    var chargingCrossbow: Boolean = false,
    var dancing: Boolean = false
) : UmpaAbstractPiglinMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaPiglinMetadata {
        return super.clone() as UmpaPiglinMetadata
    }

    companion object {
        private val empty = UmpaPiglinMetadata()
    }
}

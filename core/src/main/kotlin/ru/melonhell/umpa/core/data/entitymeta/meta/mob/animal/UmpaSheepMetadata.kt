package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata
import ru.melonhell.umpa.core.enums.UmpaDyeColor

open class UmpaSheepMetadata(
    var color: UmpaDyeColor = UmpaDyeColor.WHITE,
    var sheared: Boolean = false
) : UmpaAnimalMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaSheepMetadata {
        return super.clone() as UmpaSheepMetadata
    }

    companion object {
        private val empty = UmpaSheepMetadata()
    }
}

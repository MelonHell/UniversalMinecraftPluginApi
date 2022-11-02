package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaTamableAnimalMetadata
import ru.melonhell.umpa.core.enums.UmpaDyeColor

open class UmpaWolfMetadata(
    var interested: Boolean = false,
    var collarColor: UmpaDyeColor = UmpaDyeColor.RED,
    var remainingAngerTime: Int = 0
) : UmpaTamableAnimalMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaWolfMetadata {
        return super.clone() as UmpaWolfMetadata
    }

    companion object {
        private val empty = UmpaWolfMetadata()
    }
}

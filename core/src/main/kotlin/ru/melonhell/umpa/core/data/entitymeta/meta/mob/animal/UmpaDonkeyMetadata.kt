package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractChestedHorseMetadata

open class UmpaDonkeyMetadata : UmpaAbstractChestedHorseMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaDonkeyMetadata {
        return super.clone() as UmpaDonkeyMetadata
    }

    companion object {
        private val empty = UmpaDonkeyMetadata()
    }
}

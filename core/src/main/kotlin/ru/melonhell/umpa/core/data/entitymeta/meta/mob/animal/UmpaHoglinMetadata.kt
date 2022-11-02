package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata

open class UmpaHoglinMetadata(
    var immuneToZombification: Boolean = false
) : UmpaAnimalMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaHoglinMetadata {
        return super.clone() as UmpaHoglinMetadata
    }

    companion object {
        private val empty = UmpaHoglinMetadata()
    }
}

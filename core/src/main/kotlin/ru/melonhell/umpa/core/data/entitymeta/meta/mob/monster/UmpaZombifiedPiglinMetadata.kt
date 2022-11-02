package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

open class UmpaZombifiedPiglinMetadata : UmpaZombieMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaZombifiedPiglinMetadata {
        return super.clone() as UmpaZombifiedPiglinMetadata
    }

    companion object {
        private val empty = UmpaZombifiedPiglinMetadata()
    }
}

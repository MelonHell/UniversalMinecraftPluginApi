package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

open class UmpaHuskMetadata : UmpaZombieMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaHuskMetadata {
        return super.clone() as UmpaHuskMetadata
    }

    companion object {
        private val empty = UmpaHuskMetadata()
    }
}

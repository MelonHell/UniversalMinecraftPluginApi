package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

open class UmpaDrownedMetadata : UmpaZombieMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaDrownedMetadata {
        return super.clone() as UmpaDrownedMetadata
    }

    companion object {
        private val empty = UmpaDrownedMetadata()
    }
}

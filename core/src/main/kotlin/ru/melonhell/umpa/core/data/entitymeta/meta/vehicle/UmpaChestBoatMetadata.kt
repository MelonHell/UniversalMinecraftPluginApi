package ru.melonhell.umpa.core.data.entitymeta.meta.vehicle

open class UmpaChestBoatMetadata : UmpaBoatMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaChestBoatMetadata {
        return super.clone() as UmpaChestBoatMetadata
    }

    companion object {
        private val empty = UmpaChestBoatMetadata()
    }
}

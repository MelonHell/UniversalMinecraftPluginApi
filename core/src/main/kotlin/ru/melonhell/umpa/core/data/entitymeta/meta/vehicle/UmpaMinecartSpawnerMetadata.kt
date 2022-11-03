package ru.melonhell.umpa.core.data.entitymeta.meta.vehicle

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractMinecartMetadata

open class UmpaMinecartSpawnerMetadata : UmpaAbstractMinecartMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaMinecartSpawnerMetadata {
        return super.clone() as UmpaMinecartSpawnerMetadata
    }

    companion object {
        private val empty = UmpaMinecartSpawnerMetadata()
    }
}

package ru.melonhell.umpa.core.data.entitymeta.meta.vehicle

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractMinecartContainerMetadata

open class UmpaMinecartChestMetadata : UmpaAbstractMinecartContainerMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaMinecartChestMetadata {
        return super.clone() as UmpaMinecartChestMetadata
    }

    companion object {
        private val empty = UmpaMinecartChestMetadata()
    }
}

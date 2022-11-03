package ru.melonhell.umpa.core.data.entitymeta.meta.vehicle

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractMinecartMetadata

open class UmpaMinecartMetadata : UmpaAbstractMinecartMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaMinecartMetadata {
        return super.clone() as UmpaMinecartMetadata
    }

    companion object {
        private val empty = UmpaMinecartMetadata()
    }
}

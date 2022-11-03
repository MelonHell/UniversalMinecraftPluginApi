package ru.melonhell.umpa.core.data.entitymeta.meta.vehicle

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractMinecartMetadata

open class UmpaMinecartFurnaceMetadata(
    var fuel: Boolean = false
) : UmpaAbstractMinecartMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaMinecartFurnaceMetadata {
        return super.clone() as UmpaMinecartFurnaceMetadata
    }

    companion object {
        private val empty = UmpaMinecartFurnaceMetadata()
    }
}

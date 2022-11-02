package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata

open class UmpaProjectileMetadata : UmpaEntityMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaProjectileMetadata {
        return super.clone() as UmpaProjectileMetadata
    }

    companion object {
        private val empty = UmpaProjectileMetadata()
    }
}

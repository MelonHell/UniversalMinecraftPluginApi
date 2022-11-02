package ru.melonhell.umpa.core.data.entitymeta.meta.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaProjectileMetadata

open class UmpaLlamaSpitMetadata : UmpaProjectileMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaLlamaSpitMetadata {
        return super.clone() as UmpaLlamaSpitMetadata
    }

    companion object {
        private val empty = UmpaLlamaSpitMetadata()
    }
}

package ru.melonhell.umpa.core.data.entitymeta.meta.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaFireballMetadata

open class UmpaLargeFireballMetadata : UmpaFireballMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaLargeFireballMetadata {
        return super.clone() as UmpaLargeFireballMetadata
    }

    companion object {
        private val empty = UmpaLargeFireballMetadata()
    }
}

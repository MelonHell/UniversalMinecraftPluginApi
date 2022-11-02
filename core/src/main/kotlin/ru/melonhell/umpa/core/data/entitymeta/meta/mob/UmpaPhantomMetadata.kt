package ru.melonhell.umpa.core.data.entitymeta.meta.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaFlyingMobMetadata

open class UmpaPhantomMetadata(
    var size: Int = 0
) : UmpaFlyingMobMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaPhantomMetadata {
        return super.clone() as UmpaPhantomMetadata
    }

    companion object {
        private val empty = UmpaPhantomMetadata()
    }
}

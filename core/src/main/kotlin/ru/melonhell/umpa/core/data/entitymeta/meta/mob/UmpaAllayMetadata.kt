package ru.melonhell.umpa.core.data.entitymeta.meta.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaPathfinderMobMetadata

open class UmpaAllayMetadata(
    var dancing: Boolean = false,
    var canDuplicate: Boolean = true
) : UmpaPathfinderMobMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaAllayMetadata {
        return super.clone() as UmpaAllayMetadata
    }

    companion object {
        private val empty = UmpaAllayMetadata()
    }
}

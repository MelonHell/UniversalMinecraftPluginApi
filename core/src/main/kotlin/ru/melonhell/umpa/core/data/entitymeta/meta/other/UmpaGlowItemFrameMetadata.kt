package ru.melonhell.umpa.core.data.entitymeta.meta.other

open class UmpaGlowItemFrameMetadata : UmpaItemFrameMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaGlowItemFrameMetadata {
        return super.clone() as UmpaGlowItemFrameMetadata
    }

    companion object {
        private val empty = UmpaGlowItemFrameMetadata()
    }
}

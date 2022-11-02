package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaAbstractGolemMetadata : UmpaPathfinderMobMetadata() {
    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaAbstractGolemMetadata {
        return super.clone() as UmpaAbstractGolemMetadata
    }

    companion object {
        private val empty = UmpaAbstractGolemMetadata()
    }
}

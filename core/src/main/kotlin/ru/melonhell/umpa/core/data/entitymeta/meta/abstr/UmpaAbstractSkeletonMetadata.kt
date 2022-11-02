package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaAbstractSkeletonMetadata : UmpaMonsterMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaAbstractSkeletonMetadata {
        return super.clone() as UmpaAbstractSkeletonMetadata
    }

    companion object {
        private val empty = UmpaAbstractSkeletonMetadata()
    }
}

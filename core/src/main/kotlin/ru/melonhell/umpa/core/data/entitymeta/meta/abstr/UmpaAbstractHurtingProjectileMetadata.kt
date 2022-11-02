package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaAbstractHurtingProjectileMetadata : UmpaProjectileMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaAbstractHurtingProjectileMetadata {
        return super.clone() as UmpaAbstractHurtingProjectileMetadata
    }

    companion object {
        private val empty = UmpaAbstractHurtingProjectileMetadata()
    }
}

package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaAbstractSchoolingFishMetadata : UmpaAbstractFishMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaAbstractSchoolingFishMetadata {
        return super.clone() as UmpaAbstractSchoolingFishMetadata
    }

    companion object {
        private val empty = UmpaAbstractSchoolingFishMetadata()
    }
}

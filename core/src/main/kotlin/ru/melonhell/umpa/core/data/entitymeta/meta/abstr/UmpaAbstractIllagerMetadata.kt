package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaAbstractIllagerMetadata : UmpaRaiderMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaAbstractIllagerMetadata {
        return super.clone() as UmpaAbstractIllagerMetadata
    }

    companion object {
        private val empty = UmpaAbstractIllagerMetadata()
    }
}

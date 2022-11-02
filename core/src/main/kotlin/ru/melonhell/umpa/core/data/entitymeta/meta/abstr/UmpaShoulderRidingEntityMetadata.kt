package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaShoulderRidingEntityMetadata : UmpaTamableAnimalMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaShoulderRidingEntityMetadata {
        return super.clone() as UmpaShoulderRidingEntityMetadata
    }

    companion object {
        private val empty = UmpaShoulderRidingEntityMetadata()
    }
}

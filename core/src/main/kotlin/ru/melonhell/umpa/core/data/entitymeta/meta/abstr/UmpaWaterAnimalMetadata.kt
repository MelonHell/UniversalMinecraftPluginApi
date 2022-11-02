package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

open class UmpaWaterAnimalMetadata : UmpaPathfinderMobMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaWaterAnimalMetadata {
        return super.clone() as UmpaWaterAnimalMetadata
    }

    companion object {
        private val empty = UmpaWaterAnimalMetadata()
    }
}

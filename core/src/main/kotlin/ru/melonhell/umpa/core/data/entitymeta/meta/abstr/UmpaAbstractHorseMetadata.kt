package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

import java.util.*

open class UmpaAbstractHorseMetadata(
    var tame: Boolean = false,
    var saddled: Boolean = false,
    var hasBred: Boolean = false,
    var eating: Boolean = false,
    var rearing: Boolean = false,
    var mouthOpen: Boolean = false,
    var ownerUuid: Optional<UUID> = Optional.empty()
) : UmpaAnimalMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaAbstractHorseMetadata {
        return super.clone() as UmpaAbstractHorseMetadata
    }

    companion object {
        private val empty = UmpaAbstractHorseMetadata()
    }
}

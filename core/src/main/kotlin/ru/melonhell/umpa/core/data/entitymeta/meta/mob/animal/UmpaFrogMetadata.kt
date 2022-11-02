package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata
import java.util.*

open class UmpaFrogMetadata(
    var type: Type = Type.TEMPERATE,
    var tongueTargetId: OptionalInt = OptionalInt.empty()
) : UmpaAnimalMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaFrogMetadata {
        return super.clone() as UmpaFrogMetadata
    }

    companion object {
        private val empty = UmpaFrogMetadata()
    }

    enum class Type {
        TEMPERATE,
        WARM,
        COLD
    }
}

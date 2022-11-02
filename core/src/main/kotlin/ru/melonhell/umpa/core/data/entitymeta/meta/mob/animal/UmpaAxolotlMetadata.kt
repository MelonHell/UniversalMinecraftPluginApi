package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAnimalMetadata

open class UmpaAxolotlMetadata(
    var type: Type = Type.LUCY,
    var playingDead: Boolean = false,
    var fromBucket: Boolean = false
) : UmpaAnimalMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaAxolotlMetadata {
        return super.clone() as UmpaAxolotlMetadata
    }

    companion object {
        private val empty = UmpaAxolotlMetadata()
    }

    enum class Type {
        LUCY,
        WILD,
        GOLD,
        CYAN,
        BLUE
    }
}

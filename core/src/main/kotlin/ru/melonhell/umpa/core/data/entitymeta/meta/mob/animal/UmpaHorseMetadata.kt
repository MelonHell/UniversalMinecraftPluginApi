package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractHorseMetadata

open class UmpaHorseMetadata(
    var baseColor: Color = Color.WHITE,
    var markings: Marking = Marking.NONE
) : UmpaAbstractHorseMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaHorseMetadata {
        return super.clone() as UmpaHorseMetadata
    }

    companion object {
        private val empty = UmpaHorseMetadata()
    }

    enum class Color {
        WHITE,
        CREAMY,
        CHESTNUT,
        BROWN,
        BLACK,
        GRAY,
        DARK_BROWN;
    }

    enum class Marking {
        NONE,
        WHITE,
        WHITE_FIELD,
        WHITE_DOTS,
        BLACK_DOTS;
    }
}

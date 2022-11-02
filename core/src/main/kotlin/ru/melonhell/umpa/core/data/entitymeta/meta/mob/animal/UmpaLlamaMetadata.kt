package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractChestedHorseMetadata
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import java.util.*

open class UmpaLlamaMetadata(
    var strength: Int = 0,
    var carpetColor: Optional<UmpaDyeColor> = Optional.empty(),
    var type: Type = Type.CREAMY
) : UmpaAbstractChestedHorseMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaLlamaMetadata {
        return super.clone() as UmpaLlamaMetadata
    }

    companion object {
        private val empty = UmpaLlamaMetadata()
    }

    enum class Type {
        CREAMY,
        WHITE,
        BROWN,
        GRAY
    }
}

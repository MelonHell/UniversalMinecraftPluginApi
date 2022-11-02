package ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractSchoolingFishMetadata
import ru.melonhell.umpa.core.enums.UmpaDyeColor

open class UmpaTropicalFishMetadata(
    var pattern: Pattern = Pattern.KOB,
    var bodyColor: UmpaDyeColor = UmpaDyeColor.WHITE,
    var patternColor: UmpaDyeColor = UmpaDyeColor.WHITE,
) : UmpaAbstractSchoolingFishMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaTropicalFishMetadata {
        return super.clone() as UmpaTropicalFishMetadata
    }

    companion object {
        private val empty = UmpaTropicalFishMetadata()
    }

    enum class Pattern {
        KOB,
        SUNSTREAK,
        SNOOPER,
        DASHER,
        BRINELY,
        SPOTTY,
        FLOPPER,
        STRIPEY,
        GLITTER,
        BLOCKFISH,
        BETTY,
        CLAYFISH;
    }
}

package ru.melonhell.umpa.core.data.entitymeta.meta.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata

open class UmpaExperienceOrbMetadata : UmpaEntityMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaExperienceOrbMetadata {
        return super.clone() as UmpaExperienceOrbMetadata
    }

    companion object {
        private val empty = UmpaExperienceOrbMetadata()
    }
}

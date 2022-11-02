package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMonsterMetadata

open class UmpaGiantMetadata : UmpaMonsterMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaGiantMetadata {
        return super.clone() as UmpaGiantMetadata
    }

    companion object {
        private val empty = UmpaGiantMetadata()
    }
}

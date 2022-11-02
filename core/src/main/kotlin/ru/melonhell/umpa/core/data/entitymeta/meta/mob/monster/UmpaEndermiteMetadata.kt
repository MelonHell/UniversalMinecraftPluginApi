package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMonsterMetadata

open class UmpaEndermiteMetadata : UmpaMonsterMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaEndermiteMetadata {
        return super.clone() as UmpaEndermiteMetadata
    }

    companion object {
        private val empty = UmpaEndermiteMetadata()
    }
}

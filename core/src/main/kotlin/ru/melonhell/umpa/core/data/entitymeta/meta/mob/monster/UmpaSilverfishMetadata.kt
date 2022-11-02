package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMonsterMetadata

open class UmpaSilverfishMetadata : UmpaMonsterMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaSilverfishMetadata {
        return super.clone() as UmpaSilverfishMetadata
    }

    companion object {
        private val empty = UmpaSilverfishMetadata()
    }
}

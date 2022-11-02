package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractPiglinMetadata

open class UmpaPiglinBruteMetadata : UmpaAbstractPiglinMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaPiglinBruteMetadata {
        return super.clone() as UmpaPiglinBruteMetadata
    }

    companion object {
        private val empty = UmpaPiglinBruteMetadata()
    }
}

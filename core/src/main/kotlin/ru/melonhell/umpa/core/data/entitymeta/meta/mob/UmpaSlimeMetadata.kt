package ru.melonhell.umpa.core.data.entitymeta.meta.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMobMetadata

open class UmpaSlimeMetadata(
    var size: Int = 1
) : UmpaMobMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaSlimeMetadata {
        return super.clone() as UmpaSlimeMetadata
    }

    companion object {
        private val empty = UmpaSlimeMetadata()
    }
}

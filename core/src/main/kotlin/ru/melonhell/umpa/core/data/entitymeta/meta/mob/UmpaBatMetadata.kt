package ru.melonhell.umpa.core.data.entitymeta.meta.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAmbientCreatureMetadata

open class UmpaBatMetadata(
    var hanging: Boolean = false
) : UmpaAmbientCreatureMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaBatMetadata {
        return super.clone() as UmpaBatMetadata
    }

    companion object {
        private val empty = UmpaBatMetadata()
    }
}

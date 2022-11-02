package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMonsterMetadata

open class UmpaSpiderMetadata(
    var climbing: Boolean = false
) : UmpaMonsterMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaSpiderMetadata {
        return super.clone() as UmpaSpiderMetadata
    }

    companion object {
        private val empty = UmpaSpiderMetadata()
    }
}

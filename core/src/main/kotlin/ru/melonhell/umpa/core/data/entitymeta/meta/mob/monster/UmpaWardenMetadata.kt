package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMonsterMetadata

open class UmpaWardenMetadata(
    var angerLevel: Int = 0
) : UmpaMonsterMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaWardenMetadata {
        return super.clone() as UmpaWardenMetadata
    }

    companion object {
        private val empty = UmpaWardenMetadata()
    }
}

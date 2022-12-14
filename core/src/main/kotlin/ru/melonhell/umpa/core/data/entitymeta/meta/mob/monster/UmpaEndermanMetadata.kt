package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMonsterMetadata
import ru.melonhell.umpa.core.wrappers.UmpaBlockData
import java.util.*

open class UmpaEndermanMetadata(
    var blockInHandsId: Optional<UmpaBlockData> = Optional.empty(),
    var creepy: Boolean = false,
    var staredAt: Boolean = false
) : UmpaMonsterMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaEndermanMetadata {
        return super.clone() as UmpaEndermanMetadata
    }

    companion object {
        private val empty = UmpaEndermanMetadata()
    }
}

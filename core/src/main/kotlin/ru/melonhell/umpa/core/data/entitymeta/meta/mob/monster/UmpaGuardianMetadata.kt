package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMonsterMetadata

open class UmpaGuardianMetadata(
    var moving: Boolean = false,
    var attackTargetId: Int = 0
) : UmpaMonsterMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaGuardianMetadata {
        return super.clone() as UmpaGuardianMetadata
    }

    companion object {
        private val empty = UmpaGuardianMetadata()
    }
}

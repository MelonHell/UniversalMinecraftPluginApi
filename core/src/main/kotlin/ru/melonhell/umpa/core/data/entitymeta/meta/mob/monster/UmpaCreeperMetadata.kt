package ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMonsterMetadata

open class UmpaCreeperMetadata(
    var swellDir: State = State.IDLE,
    var isCharged: Boolean = false,
    var isIgnited: Boolean = false
) : UmpaMonsterMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaCreeperMetadata {
        return super.clone() as UmpaCreeperMetadata
    }

    companion object {
        private val empty = UmpaCreeperMetadata()
    }

    enum class State {
        IDLE,
        FUSE
    }
}

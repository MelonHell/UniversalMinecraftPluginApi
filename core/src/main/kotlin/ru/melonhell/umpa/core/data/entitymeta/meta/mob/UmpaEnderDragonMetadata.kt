package ru.melonhell.umpa.core.data.entitymeta.meta.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMobMetadata

open class UmpaEnderDragonMetadata(
    var phase: Phase = Phase.HOVERING
) : UmpaMobMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaEnderDragonMetadata {
        return super.clone() as UmpaEnderDragonMetadata
    }

    companion object {
        private val empty = UmpaEnderDragonMetadata()
    }

    enum class Phase {
        HOLDING_PATTERN,
        STRAFE_PLAYER,
        LANDING_APPROACH,
        LANDING,
        TAKEOFF,
        SITTING_FLAMING,
        SITTING_SCANNING,
        SITTING_ATTACKING,
        CHARGING_PLAYER,
        DYING,
        HOVERING
    }
}

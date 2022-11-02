package ru.melonhell.umpa.core.data.entitymeta.meta.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaThrowableItemProjectileMetadata

open class UmpaThrownExperienceBottleMetadata : UmpaThrowableItemProjectileMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaThrownExperienceBottleMetadata {
        return super.clone() as UmpaThrownExperienceBottleMetadata
    }

    companion object {
        private val empty = UmpaThrownExperienceBottleMetadata()
    }
}

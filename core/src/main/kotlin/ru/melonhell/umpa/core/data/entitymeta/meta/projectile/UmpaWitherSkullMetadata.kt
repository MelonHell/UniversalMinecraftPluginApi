package ru.melonhell.umpa.core.data.entitymeta.meta.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractHurtingProjectileMetadata

open class UmpaWitherSkullMetadata(
    var invulnerable: Boolean = false
) : UmpaAbstractHurtingProjectileMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaWitherSkullMetadata {
        return super.clone() as UmpaWitherSkullMetadata
    }

    companion object {
        private val empty = UmpaWitherSkullMetadata()
    }
}

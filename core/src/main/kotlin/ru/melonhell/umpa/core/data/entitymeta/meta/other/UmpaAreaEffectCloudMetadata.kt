package ru.melonhell.umpa.core.data.entitymeta.meta.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.enums.keyed.UmpaParticleType
import ru.melonhell.umpa.core.utils.UmpaColor

open class UmpaAreaEffectCloudMetadata(
    var radius: Float = 0.5F,
    var color: UmpaColor = UmpaColor(),
    var waiting: Boolean = false,
    var particle: UmpaParticleType = UmpaParticleType.ENTITY_EFFECT
) : UmpaEntityMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaAreaEffectCloudMetadata {
        return super.clone() as UmpaAreaEffectCloudMetadata
    }

    companion object {
        private val empty = UmpaAreaEffectCloudMetadata()
    }
}

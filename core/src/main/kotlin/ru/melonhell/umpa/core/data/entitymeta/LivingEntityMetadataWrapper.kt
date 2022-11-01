package ru.melonhell.umpa.core.data.entitymeta

import ru.melonhell.umpa.core.utils.UmpaBlockPos

open class LivingEntityMetadataWrapper(
    var handActive: Boolean = false,
    var activeHand: Int = 0,
    var isInRiptideSpinAttack: Boolean = false,
    var health: Float = 1.0f,
    var potionEffectColor: Int = 0,
    var isPotionEffectAmbient: Boolean = false,
    var numberOfArrowsInEntity: Int = 0,
    var numberOfBeeStingersInEntity: Int = 0,
    var sleepingLocation: UmpaBlockPos? = null,
) : EntityMetadataWrapper() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): LivingEntityMetadataWrapper {
        return super.clone() as LivingEntityMetadataWrapper
    }

    companion object {
        private val empty = LivingEntityMetadataWrapper()
    }
}
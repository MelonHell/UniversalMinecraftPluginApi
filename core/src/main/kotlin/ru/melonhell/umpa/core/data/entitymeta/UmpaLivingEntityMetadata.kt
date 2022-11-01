package ru.melonhell.umpa.core.data.entitymeta

import ru.melonhell.umpa.core.enums.UmpaHand
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import java.util.*

open class UmpaLivingEntityMetadata(
    var handActive: Boolean = false,
    var activeHand: UmpaHand = UmpaHand.MAIN_HAND,
    var isInRiptideSpinAttack: Boolean = false,
    var health: Float = 1.0f,
    var potionEffectColor: Int = 0,
    var isPotionEffectAmbient: Boolean = false,
    var numberOfArrowsInEntity: Int = 0,
    var numberOfBeeStingersInEntity: Int = 0,
    var sleepingLocation: Optional<UmpaBlockPos> = Optional.empty()
) : UmpaEntityMetadata() {

    override val isEmpty: Boolean
        get() = this == empty

    override fun clone(): UmpaLivingEntityMetadata {
        return super.clone() as UmpaLivingEntityMetadata
    }

    companion object {
        private val empty = UmpaLivingEntityMetadata()
    }
}
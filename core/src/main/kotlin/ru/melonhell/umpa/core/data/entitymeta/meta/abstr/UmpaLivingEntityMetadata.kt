package ru.melonhell.umpa.core.data.entitymeta.meta.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.enums.UmpaHand
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.utils.UmpaColor
import java.util.*

open class UmpaLivingEntityMetadata(
    var handActive: Boolean = false,
    var activeHand: UmpaHand = UmpaHand.MAIN_HAND,
    var inRiptideSpinAttack: Boolean = false,
    var health: Float = 1.0f,
    var potionEffectColor: Optional<UmpaColor> = Optional.empty(),
    var potionEffectAmbient: Boolean = false,
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
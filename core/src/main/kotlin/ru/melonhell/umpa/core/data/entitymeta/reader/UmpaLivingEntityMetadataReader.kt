package ru.melonhell.umpa.core.data.entitymeta.reader

import ru.melonhell.umpa.core.utils.UmpaBlockPos

interface UmpaLivingEntityMetadataReader : UmpaEntityMetadataReader {
    var handActive: Boolean
    var activeHand: Int
    var isInRiptideSpinAttack: Boolean
    var health: Float
    var potionEffectColor: Int
    var isPotionEffectAmbient: Boolean
    var numberOfArrowsInEntity: Int
    var numberOfBeeStingersInEntity: Int
    var sleepingLocation: UmpaBlockPos?
}
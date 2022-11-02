package ru.melonhell.umpa.core.data.entitymeta.reader.readers

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaLivingEntityMetadata
import ru.melonhell.umpa.core.enums.UmpaHand
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import java.util.*

interface UmpaLivingEntityMetadataReader : UmpaEntityMetadataReader {
    var handActive: Boolean?
    var activeHand: UmpaHand?
    var isInRiptideSpinAttack: Boolean?
    var health: Float?
    var potionEffectColor: Int?
    var isPotionEffectAmbient: Boolean?
    var numberOfArrowsInEntity: Int?
    var numberOfBeeStingersInEntity: Int?
    var sleepingLocation: Optional<UmpaBlockPos>?

    override fun read(): UmpaLivingEntityMetadata = UmpaLivingEntityMetadata().apply { read(this) }

    override fun read(meta: UmpaEntityMetadata) {
        super.read(meta)
        if (meta !is UmpaLivingEntityMetadata) return
        handActive?.let { meta.handActive = it }
        activeHand?.let { meta.activeHand = it }
        isInRiptideSpinAttack?.let { meta.inRiptideSpinAttack = it }
        health?.let { meta.health = it }
        potionEffectColor?.let { meta.potionEffectColor = it }
        isPotionEffectAmbient?.let { meta.potionEffectAmbient = it }
        numberOfArrowsInEntity?.let { meta.numberOfArrowsInEntity = it }
        numberOfBeeStingersInEntity?.let { meta.numberOfBeeStingersInEntity = it }
        sleepingLocation?.let { meta.sleepingLocation = it }
    }

    override fun apply(meta: UmpaEntityMetadata) {
        super.apply(meta)
        if (meta !is UmpaLivingEntityMetadata) return
        handActive = meta.handActive
        activeHand = meta.activeHand
        isInRiptideSpinAttack = meta.inRiptideSpinAttack
        health = meta.health
        potionEffectColor = meta.potionEffectColor
        isPotionEffectAmbient = meta.potionEffectAmbient
        numberOfArrowsInEntity = meta.numberOfArrowsInEntity
        numberOfBeeStingersInEntity = meta.numberOfBeeStingersInEntity
        sleepingLocation = meta.sleepingLocation
    }
}
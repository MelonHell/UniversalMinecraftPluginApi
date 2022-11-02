package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaLivingEntityMetadata
import ru.melonhell.umpa.core.enums.UmpaHand
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaLivingEntityMetadataEditor : ru.melonhell.umpa.core.data.entitymeta.editor.UmpaEntityMetadataEditor {

    fun readHandActive(raw: UmpaRawEntityMetadata): Boolean?
    fun writeHandActive(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readActiveHand(raw: UmpaRawEntityMetadata): UmpaHand?
    fun writeActiveHand(raw: UmpaRawEntityMetadata, value: UmpaHand?)

    fun readInRiptideSpinAttack(raw: UmpaRawEntityMetadata): Boolean?
    fun writeInRiptideSpinAttack(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readHealth(raw: UmpaRawEntityMetadata): Float?
    fun writeHealth(raw: UmpaRawEntityMetadata, value: Float?)

    fun readPotionEffectColor(raw: UmpaRawEntityMetadata): Int?
    fun writePotionEffectColor(raw: UmpaRawEntityMetadata, value: Int?)

    fun readPotionEffectAmbient(raw: UmpaRawEntityMetadata): Boolean?
    fun writePotionEffectAmbient(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readNumberOfArrowsInEntity(raw: UmpaRawEntityMetadata): Int?
    fun writeNumberOfArrowsInEntity(raw: UmpaRawEntityMetadata, value: Int?)

    fun readNumberOfBeeStingersInEntity(raw: UmpaRawEntityMetadata): Int?
    fun writeNumberOfBeeStingersInEntity(raw: UmpaRawEntityMetadata, value: Int?)

    fun readSleepingLocation(raw: UmpaRawEntityMetadata): Optional<UmpaBlockPos>?
    fun writeSleepingLocation(raw: UmpaRawEntityMetadata, value: Optional<UmpaBlockPos>?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaLivingEntityMetadata =
        UmpaLivingEntityMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaLivingEntityMetadata) return
        readHandActive(raw)?.let { meta.handActive = it }
        readActiveHand(raw)?.let { meta.activeHand = it }
        readInRiptideSpinAttack(raw)?.let { meta.inRiptideSpinAttack = it }
        readHealth(raw)?.let { meta.health = it }
        readPotionEffectColor(raw)?.let { meta.potionEffectColor = it }
        readPotionEffectAmbient(raw)?.let { meta.potionEffectAmbient = it }
        readNumberOfArrowsInEntity(raw)?.let { meta.numberOfArrowsInEntity = it }
        readNumberOfBeeStingersInEntity(raw)?.let { meta.numberOfBeeStingersInEntity = it }
        readSleepingLocation(raw)?.let { meta.sleepingLocation = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaLivingEntityMetadata) return
        writeHandActive(raw, meta.handActive)
        writeActiveHand(raw, meta.activeHand)
        writeInRiptideSpinAttack(raw, meta.inRiptideSpinAttack)
        writeHealth(raw, meta.health)
        writePotionEffectColor(raw, meta.potionEffectColor)
        writePotionEffectAmbient(raw, meta.potionEffectAmbient)
        writeNumberOfArrowsInEntity(raw, meta.numberOfArrowsInEntity)
        writeNumberOfBeeStingersInEntity(raw, meta.numberOfBeeStingersInEntity)
        writeSleepingLocation(raw, meta.sleepingLocation)
    }
}
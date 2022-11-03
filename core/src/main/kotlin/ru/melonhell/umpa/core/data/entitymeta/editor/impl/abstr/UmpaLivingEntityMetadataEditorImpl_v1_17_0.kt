package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaLivingEntityMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.UmpaEntityMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.enums.UmpaHand
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.utils.UmpaColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaLivingEntityMetadataEditorImpl_v1_17_0 : UmpaLivingEntityMetadataEditor,
    UmpaEntityMetadataEditorImpl_v1_17_0() {
    override fun readHandActive(raw: UmpaRawEntityMetadata) = raw.getFlag(8, 0)
    override fun writeHandActive(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(8, 0, value)

    override fun readActiveHand(raw: UmpaRawEntityMetadata) =
        raw.getFlag(8, 1)?.let { if (it) UmpaHand.OFF_HAND else UmpaHand.MAIN_HAND }

    override fun writeActiveHand(raw: UmpaRawEntityMetadata, value: UmpaHand?) =
        raw.setFlag(8, 1, value?.equals(UmpaHand.OFF_HAND))

    override fun readInRiptideSpinAttack(raw: UmpaRawEntityMetadata) = raw.getFlag(8, 2)
    override fun writeInRiptideSpinAttack(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(8, 2, value)

    override fun readHealth(raw: UmpaRawEntityMetadata) = raw.getValue(9, Float::class.java)
    override fun writeHealth(raw: UmpaRawEntityMetadata, value: Float?) = raw.setValue(9, value)

    override fun readPotionEffectColor(raw: UmpaRawEntityMetadata) =
        raw.getValue(10, Int::class.java)?.let { if (it == 0) Optional.empty() else Optional.of(UmpaColor(it)) }

    override fun writePotionEffectColor(raw: UmpaRawEntityMetadata, value: Optional<UmpaColor>?) =
        raw.setValue(10, value?.map { it.intValue }?.orElse(0))

    override fun readPotionEffectAmbient(raw: UmpaRawEntityMetadata) = raw.getValue(11, Boolean::class.java)
    override fun writePotionEffectAmbient(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(11, value)

    override fun readNumberOfArrowsInEntity(raw: UmpaRawEntityMetadata) = raw.getValue(12, Int::class.java)
    override fun writeNumberOfArrowsInEntity(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(12, value)

    override fun readNumberOfBeeStingersInEntity(raw: UmpaRawEntityMetadata) = raw.getValue(13, Int::class.java)
    override fun writeNumberOfBeeStingersInEntity(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(13, value)

    override fun readSleepingLocation(raw: UmpaRawEntityMetadata) = raw.getOptional(14, UmpaBlockPos::class.java)
    override fun writeSleepingLocation(raw: UmpaRawEntityMetadata, value: Optional<UmpaBlockPos>?) =
        raw.setOptional(14, value, UmpaBlockPos::class.java)
}
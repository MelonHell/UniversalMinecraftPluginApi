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
    override fun readHandActive(raw: UmpaRawEntityMetadata) = raw.readFlag(8, 0)
    override fun writeHandActive(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(8, 0, value)

    override fun readActiveHand(raw: UmpaRawEntityMetadata) =
        raw.readFlag(8, 1)?.let { if (it) UmpaHand.OFF_HAND else UmpaHand.MAIN_HAND }

    override fun writeActiveHand(raw: UmpaRawEntityMetadata, value: UmpaHand?) =
        raw.writeFlag(8, 1, value?.equals(UmpaHand.OFF_HAND))

    override fun readInRiptideSpinAttack(raw: UmpaRawEntityMetadata) = raw.readFlag(8, 2)
    override fun writeInRiptideSpinAttack(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(8, 2, value)

    override fun readHealth(raw: UmpaRawEntityMetadata) = raw.readValue(9, Float::class.java)
    override fun writeHealth(raw: UmpaRawEntityMetadata, value: Float?) = raw.writeValue(9, value, Float::class.java)

    override fun readPotionEffectColor(raw: UmpaRawEntityMetadata) =
        raw.readValue(10, Int::class.java)?.let { if (it == 0) Optional.empty() else Optional.of(UmpaColor(it)) }

    override fun writePotionEffectColor(raw: UmpaRawEntityMetadata, value: Optional<UmpaColor>?) =
        raw.writeValue(10, value?.map { it.intValue }?.orElse(0), Int::class.java)

    override fun readPotionEffectAmbient(raw: UmpaRawEntityMetadata) = raw.readValue(11, Boolean::class.java)
    override fun writePotionEffectAmbient(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(11, value, Boolean::class.java)

    override fun readNumberOfArrowsInEntity(raw: UmpaRawEntityMetadata) = raw.readValue(12, Int::class.java)
    override fun writeNumberOfArrowsInEntity(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(12, value, Int::class.java)

    override fun readNumberOfBeeStingersInEntity(raw: UmpaRawEntityMetadata) = raw.readValue(13, Int::class.java)
    override fun writeNumberOfBeeStingersInEntity(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(13, value, Int::class.java)

    override fun readSleepingLocation(raw: UmpaRawEntityMetadata) = raw.readOptional(14, UmpaBlockPos::class.java)
    override fun writeSleepingLocation(raw: UmpaRawEntityMetadata, value: Optional<UmpaBlockPos>?) =
        raw.writeOptional(14, value, UmpaBlockPos::class.java)
}
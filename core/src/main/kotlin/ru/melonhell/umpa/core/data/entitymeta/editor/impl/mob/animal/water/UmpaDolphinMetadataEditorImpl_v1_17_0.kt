package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal.water

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.water.UmpaDolphinMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaWaterAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaDolphinMetadataEditorImpl_v1_17_0 : UmpaDolphinMetadataEditor,
    UmpaWaterAnimalMetadataEditorImpl_v1_17_0() {
    override fun readTreasurePos(raw: UmpaRawEntityMetadata) = raw.getValue(16, UmpaBlockPos::class.java)
    override fun writeTreasurePos(raw: UmpaRawEntityMetadata, value: UmpaBlockPos?) = raw.setValue(16, value)

    override fun readHasFish(raw: UmpaRawEntityMetadata) = raw.getValue(17, Boolean::class.java)
    override fun writeHasFish(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(17, value)

    override fun readMoistnessLevel(raw: UmpaRawEntityMetadata) = raw.getValue(18, Int::class.java)
    override fun writeMoistnessLevel(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(18, value)
}
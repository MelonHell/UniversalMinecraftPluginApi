package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal.water

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.water.UmpaDolphinMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaWaterAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaDolphinMetadataEditorImpl_v1_17_0 : UmpaDolphinMetadataEditor,
    UmpaWaterAnimalMetadataEditorImpl_v1_17_0() {
    override fun readTreasurePos(raw: UmpaRawEntityMetadata) = raw.readValue(16, UmpaBlockPos::class.java)
    override fun writeTreasurePos(raw: UmpaRawEntityMetadata, value: UmpaBlockPos?) = raw.writeValue(16, value, UmpaBlockPos::class.java)

    override fun readHasFish(raw: UmpaRawEntityMetadata) = raw.readValue(17, Boolean::class.java)
    override fun writeHasFish(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(17, value, Boolean::class.java)

    override fun readMoistnessLevel(raw: UmpaRawEntityMetadata) = raw.readValue(18, Int::class.java)
    override fun writeMoistnessLevel(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(18, value, Int::class.java)
}
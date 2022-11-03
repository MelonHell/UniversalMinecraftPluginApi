package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.monster.raider

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.raider.UmpaPillagerMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractIllagerMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaPillagerMetadataEditorImpl_v1_17_0 : UmpaPillagerMetadataEditor,
    UmpaAbstractIllagerMetadataEditorImpl_v1_17_0() {
    override fun readChargingCrossbow(raw: UmpaRawEntityMetadata) = raw.getValue(17, Boolean::class.java)
    override fun writeChargingCrossbow(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(17, value)
}
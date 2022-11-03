package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.UmpaVillagerMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractVillagerMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.utils.UmpaVillagerData
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaVillagerMetadataEditorImpl_v1_17_0 : UmpaVillagerMetadataEditor,
    UmpaAbstractVillagerMetadataEditorImpl_v1_17_0() {
    override fun readVillagerData(raw: UmpaRawEntityMetadata) = raw.getValue(18, UmpaVillagerData::class.java)
    override fun writeVillagerData(raw: UmpaRawEntityMetadata, value: UmpaVillagerData?) = raw.setValue(18, value)
}
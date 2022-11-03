package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaMobMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaMobMetadataEditorImpl_v1_17_0 : UmpaMobMetadataEditor, UmpaLivingEntityMetadataEditorImpl_v1_17_0() {
    override fun readNoAi(raw: UmpaRawEntityMetadata) = raw.getFlag(15, 0)
    override fun writeNoAi(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(15, 0, value)

    override fun readLeftHanded(raw: UmpaRawEntityMetadata) = raw.getFlag(15, 1)
    override fun writeLeftHanded(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(15, 1, value)

    override fun readAggressive(raw: UmpaRawEntityMetadata) = raw.getFlag(15, 2)
    override fun writeAggressive(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(15, 2, value)
}
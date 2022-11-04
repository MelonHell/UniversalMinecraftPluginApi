package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.UmpaBatMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAmbientCreatureMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaBatMetadataEditorImpl_v1_17_0 : UmpaBatMetadataEditor, UmpaAmbientCreatureMetadataEditorImpl_v1_17_0() {
    override fun readHanging(raw: UmpaRawEntityMetadata) = raw.readFlag(16, 0)
    override fun writeHanging(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(16, 0, value)
}
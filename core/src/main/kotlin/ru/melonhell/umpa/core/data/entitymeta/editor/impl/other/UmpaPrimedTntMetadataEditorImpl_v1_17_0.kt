package ru.melonhell.umpa.core.data.entitymeta.editor.impl.other

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.other.UmpaPrimedTntMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.UmpaEntityMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaPrimedTntMetadataEditorImpl_v1_17_0 : UmpaPrimedTntMetadataEditor,
    UmpaEntityMetadataEditorImpl_v1_17_0() {
    override fun readFuse(raw: UmpaRawEntityMetadata) = raw.getValue(8, Int::class.java)
    override fun writeFuse(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(8, value)
}
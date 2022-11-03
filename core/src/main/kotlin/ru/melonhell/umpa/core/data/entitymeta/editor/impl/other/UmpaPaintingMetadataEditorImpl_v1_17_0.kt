package ru.melonhell.umpa.core.data.entitymeta.editor.impl.other

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.other.UmpaPaintingMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaHangingEntityMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaPaintingMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaPaintingMetadataEditorImpl_v1_17_0 : UmpaPaintingMetadataEditor,
    UmpaHangingEntityMetadataEditorImpl_v1_17_0() {
    override fun readType(raw: UmpaRawEntityMetadata) = raw.getValue(8, UmpaPaintingMetadata.Type::class.java)
    override fun writeType(raw: UmpaRawEntityMetadata, value: UmpaPaintingMetadata.Type?) = raw.setValue(8, value)
}
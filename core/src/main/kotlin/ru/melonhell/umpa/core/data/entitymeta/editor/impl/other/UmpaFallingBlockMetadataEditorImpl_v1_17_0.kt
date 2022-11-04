package ru.melonhell.umpa.core.data.entitymeta.editor.impl.other

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.other.UmpaFallingBlockMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.UmpaEntityMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaFallingBlockMetadataEditorImpl_v1_17_0 : UmpaFallingBlockMetadataEditor,
    UmpaEntityMetadataEditorImpl_v1_17_0() {
    override fun readStartPos(raw: UmpaRawEntityMetadata) = raw.readValue(8, UmpaBlockPos::class.java)
    override fun writeStartPos(raw: UmpaRawEntityMetadata, value: UmpaBlockPos?) = raw.writeValue(8, value, UmpaBlockPos::class.java)
}
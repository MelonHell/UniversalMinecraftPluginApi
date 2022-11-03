package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.UmpaIronGolemMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractGolemMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaIronGolemMetadataEditorImpl_v1_17_0 : UmpaIronGolemMetadataEditor,
    UmpaAbstractGolemMetadataEditorImpl_v1_17_0() {
    override fun readPlayerCreated(raw: UmpaRawEntityMetadata) = raw.getFlag(16, 0)
    override fun writePlayerCreated(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(16, 0, value)
}
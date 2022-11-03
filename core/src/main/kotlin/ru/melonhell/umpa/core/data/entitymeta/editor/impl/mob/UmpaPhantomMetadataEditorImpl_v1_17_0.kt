package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.UmpaPhantomMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaFlyingMobMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaPhantomMetadataEditorImpl_v1_17_0 : UmpaPhantomMetadataEditor,
    UmpaFlyingMobMetadataEditorImpl_v1_17_0() {
    override fun readSize(raw: UmpaRawEntityMetadata) = raw.getValue(16, Int::class.java)
    override fun writeSize(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(16, value)
}
package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.monster

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.UmpaSkeletonMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractSkeletonMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaSkeletonMetadataEditorImpl_v1_17_0 : UmpaSkeletonMetadataEditor,
    UmpaAbstractSkeletonMetadataEditorImpl_v1_17_0() {
    override fun readStrayConversion(raw: UmpaRawEntityMetadata) = raw.getValue(16, Boolean::class.java)
    override fun writeStrayConversion(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(16, value)
}
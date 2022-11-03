package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.UmpaAllayMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaPathfinderMobMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAllayMetadataEditorImpl_v1_17_0 : UmpaAllayMetadataEditor,
    UmpaPathfinderMobMetadataEditorImpl_v1_17_0() {
    override fun readDancing(raw: UmpaRawEntityMetadata) = raw.getValue(16, Boolean::class.java)
    override fun writeDancing(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(16, value)

    override fun readCanDuplicate(raw: UmpaRawEntityMetadata) = raw.getValue(17, Boolean::class.java)
    override fun writeCanDuplicate(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(17, value)
}
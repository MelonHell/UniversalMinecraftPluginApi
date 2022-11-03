package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal.water

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.water.UmpaPufferfishMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractFishMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaPufferfishMetadataEditorImpl_v1_17_0 : UmpaPufferfishMetadataEditor,
    UmpaAbstractFishMetadataEditorImpl_v1_17_0() {
    override fun readPuffState(raw: UmpaRawEntityMetadata) = raw.getValue(17, Int::class.java)
    override fun writePuffState(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(17, value)
}
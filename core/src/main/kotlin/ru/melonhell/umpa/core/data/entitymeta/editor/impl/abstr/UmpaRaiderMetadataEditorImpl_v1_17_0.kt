package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaRaiderMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaRaiderMetadataEditorImpl_v1_17_0 : UmpaRaiderMetadataEditor,
    UmpaPatrollingMonsterMetadataEditorImpl_v1_17_0() {
    override fun readCelebrating(raw: UmpaRawEntityMetadata) = raw.getValue(15, Boolean::class.java)
    override fun writeCelebrating(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(15, value)
}
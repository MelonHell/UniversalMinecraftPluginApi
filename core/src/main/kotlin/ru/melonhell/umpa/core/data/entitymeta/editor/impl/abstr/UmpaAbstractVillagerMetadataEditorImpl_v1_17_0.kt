package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractVillagerMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAbstractVillagerMetadataEditorImpl_v1_17_0 : UmpaAbstractVillagerMetadataEditor,
    UmpaAgeableMobMetadataEditorImpl_v1_17_0() {
    override fun readUnhappyCounter(raw: UmpaRawEntityMetadata) = raw.getValue(17, Int::class.java)
    override fun writeUnhappyCounter(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(17, value)
}
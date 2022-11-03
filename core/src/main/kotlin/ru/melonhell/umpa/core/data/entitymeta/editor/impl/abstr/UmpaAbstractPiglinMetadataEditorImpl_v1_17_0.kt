package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractPiglinMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAbstractPiglinMetadataEditorImpl_v1_17_0 : UmpaAbstractPiglinMetadataEditor,
    UmpaMonsterMetadataEditorImpl_v1_17_0() {
    override fun readImmuneToZombification(raw: UmpaRawEntityMetadata) = raw.getValue(16, Boolean::class.java)
    override fun writeImmuneToZombification(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(16, value)
}
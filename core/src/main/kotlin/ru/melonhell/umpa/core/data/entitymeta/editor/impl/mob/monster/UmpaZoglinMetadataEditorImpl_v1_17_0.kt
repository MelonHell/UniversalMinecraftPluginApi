package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.monster

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.UmpaZoglinMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaMonsterMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaZoglinMetadataEditorImpl_v1_17_0 : UmpaZoglinMetadataEditor, UmpaMonsterMetadataEditorImpl_v1_17_0() {
    override fun readBaby(raw: UmpaRawEntityMetadata) = raw.getValue(16, Boolean::class.java)
    override fun writeBaby(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(16, value)
}
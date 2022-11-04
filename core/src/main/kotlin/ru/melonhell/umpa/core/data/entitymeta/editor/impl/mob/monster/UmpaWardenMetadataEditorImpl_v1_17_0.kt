package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.monster

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.UmpaWardenMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaMonsterMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaWardenMetadataEditorImpl_v1_17_0 : UmpaWardenMetadataEditor, UmpaMonsterMetadataEditorImpl_v1_17_0() {
    override fun readAngerLevel(raw: UmpaRawEntityMetadata) = raw.readValue(16, Int::class.java)
    override fun writeAngerLevel(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(16, value, Int::class.java)
}
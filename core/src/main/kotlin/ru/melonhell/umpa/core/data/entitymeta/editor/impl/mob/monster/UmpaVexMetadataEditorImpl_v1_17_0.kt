package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.monster

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.UmpaVexMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaMonsterMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaVexMetadataEditorImpl_v1_17_0 : UmpaVexMetadataEditor, UmpaMonsterMetadataEditorImpl_v1_17_0() {
    override fun readAttacking(raw: UmpaRawEntityMetadata) = raw.getFlag(16, 0)
    override fun writeAttacking(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(16, 0, value)
}
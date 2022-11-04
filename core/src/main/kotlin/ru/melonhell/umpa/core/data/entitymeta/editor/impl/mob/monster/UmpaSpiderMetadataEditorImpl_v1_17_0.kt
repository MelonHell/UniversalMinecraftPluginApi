package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.monster

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.UmpaSpiderMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaMonsterMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaSpiderMetadataEditorImpl_v1_17_0 : UmpaSpiderMetadataEditor, UmpaMonsterMetadataEditorImpl_v1_17_0() {
    override fun readClimbing(raw: UmpaRawEntityMetadata) = raw.readFlag(16, 0)
    override fun writeClimbing(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(16, 0, value)
}
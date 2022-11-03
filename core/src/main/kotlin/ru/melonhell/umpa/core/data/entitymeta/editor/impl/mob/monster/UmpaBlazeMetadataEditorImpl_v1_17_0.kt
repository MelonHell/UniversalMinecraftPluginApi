package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.monster

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.UmpaBlazeMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaMonsterMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaBlazeMetadataEditorImpl_v1_17_0 : UmpaBlazeMetadataEditor, UmpaMonsterMetadataEditorImpl_v1_17_0() {
    override fun readBlazeOnFire(raw: UmpaRawEntityMetadata) = raw.getFlag(16, 0)
    override fun writeBlazeOnFire(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(16, 0, value)
}
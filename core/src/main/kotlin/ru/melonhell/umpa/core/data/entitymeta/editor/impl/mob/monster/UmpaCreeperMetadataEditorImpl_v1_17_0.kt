package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.monster

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.UmpaCreeperMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaMonsterMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaCreeperMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaCreeperMetadataEditorImpl_v1_17_0 : UmpaCreeperMetadataEditor, UmpaMonsterMetadataEditorImpl_v1_17_0() {
    override fun readSwellDir(raw: UmpaRawEntityMetadata) = raw.getValue(16, Int::class.java)
        ?.let { if (it == 1) UmpaCreeperMetadata.State.FUSE else UmpaCreeperMetadata.State.IDLE }

    override fun writeSwellDir(raw: UmpaRawEntityMetadata, value: UmpaCreeperMetadata.State?) =
        raw.setValue(16, value?.let { if (it == UmpaCreeperMetadata.State.FUSE) 1 else -1 })

    override fun readIsCharged(raw: UmpaRawEntityMetadata) = raw.getValue(17, Boolean::class.java)
    override fun writeIsCharged(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(17, value)

    override fun readIsIgnited(raw: UmpaRawEntityMetadata) = raw.getValue(18, Boolean::class.java)
    override fun writeIsIgnited(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(18, value)
}
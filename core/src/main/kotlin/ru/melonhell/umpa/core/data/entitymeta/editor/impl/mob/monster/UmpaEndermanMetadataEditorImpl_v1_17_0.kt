package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.monster

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.UmpaEndermanMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaMonsterMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaEndermanMetadataEditorImpl_v1_17_0 : UmpaEndermanMetadataEditor,
    UmpaMonsterMetadataEditorImpl_v1_17_0() {
    override fun readBlockInHandsId(raw: UmpaRawEntityMetadata) = raw.getValue(16, OptionalInt::class.java)
    override fun writeBlockInHandsId(raw: UmpaRawEntityMetadata, value: OptionalInt?) = raw.setValue(16, value)

    override fun readCreepy(raw: UmpaRawEntityMetadata) = raw.getValue(17, Boolean::class.java)
    override fun writeCreepy(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(17, value)

    override fun readStaredAt(raw: UmpaRawEntityMetadata) = raw.getValue(18, Boolean::class.java)
    override fun writeStaredAt(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(18, value)
}
package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.monster

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.UmpaEndermanMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaMonsterMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaBlockData
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaEndermanMetadataEditorImpl_v1_17_0 : UmpaEndermanMetadataEditor,
    UmpaMonsterMetadataEditorImpl_v1_17_0() {
    override fun readBlockInHandsId(raw: UmpaRawEntityMetadata) = raw.readOptional(16, UmpaBlockData::class.java)
    override fun writeBlockInHandsId(raw: UmpaRawEntityMetadata, value: Optional<UmpaBlockData>?) = raw.writeOptional(16, value, UmpaBlockData::class.java)

    override fun readCreepy(raw: UmpaRawEntityMetadata) = raw.readValue(17, Boolean::class.java)
    override fun writeCreepy(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(17, value, Boolean::class.java)

    override fun readStaredAt(raw: UmpaRawEntityMetadata) = raw.readValue(18, Boolean::class.java)
    override fun writeStaredAt(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(18, value, Boolean::class.java)
}
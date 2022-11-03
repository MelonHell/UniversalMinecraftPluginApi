package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaAxolotlMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaAxolotlMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAxolotlMetadataEditorImpl_v1_17_0 : UmpaAxolotlMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    private val types = UmpaAxolotlMetadata.Type.values()

    override fun readType(raw: UmpaRawEntityMetadata) = raw.getValue(1, Int::class.java)?.let { types[it] }
    override fun writeType(raw: UmpaRawEntityMetadata, value: UmpaAxolotlMetadata.Type?) =
        raw.setValue(1, value?.ordinal)

    override fun readPlayingDead(raw: UmpaRawEntityMetadata) = raw.getValue(18, Boolean::class.java)
    override fun writePlayingDead(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(18, value)

    override fun readFromBucket(raw: UmpaRawEntityMetadata) = raw.getValue(19, Boolean::class.java)
    override fun writeFromBucket(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(19, value)
}
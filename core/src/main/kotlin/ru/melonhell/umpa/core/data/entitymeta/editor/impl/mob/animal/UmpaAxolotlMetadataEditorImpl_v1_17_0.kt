package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaAxolotlMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaAxolotlMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAxolotlMetadataEditorImpl_v1_17_0 : UmpaAxolotlMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    private val types = UmpaAxolotlMetadata.Type.values()

    override fun readType(raw: UmpaRawEntityMetadata) = raw.readValue(1, Int::class.java)?.let { types[it] }
    override fun writeType(raw: UmpaRawEntityMetadata, value: UmpaAxolotlMetadata.Type?) =
        raw.writeValue(1, value?.ordinal, Int::class.java)

    override fun readPlayingDead(raw: UmpaRawEntityMetadata) = raw.readValue(18, Boolean::class.java)
    override fun writePlayingDead(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(18, value, Boolean::class.java)

    override fun readFromBucket(raw: UmpaRawEntityMetadata) = raw.readValue(19, Boolean::class.java)
    override fun writeFromBucket(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(19, value, Boolean::class.java)
}
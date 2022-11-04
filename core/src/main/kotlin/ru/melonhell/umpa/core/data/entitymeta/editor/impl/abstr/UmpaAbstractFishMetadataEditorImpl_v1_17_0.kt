package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractFishMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAbstractFishMetadataEditorImpl_v1_17_0 : UmpaAbstractFishMetadataEditor,
    UmpaWaterAnimalMetadataEditorImpl_v1_17_0() {
    override fun readFromBucket(raw: UmpaRawEntityMetadata) = raw.readValue(16, Boolean::class.java)
    override fun writeFromBucket(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(16, value, Boolean::class.java)
}
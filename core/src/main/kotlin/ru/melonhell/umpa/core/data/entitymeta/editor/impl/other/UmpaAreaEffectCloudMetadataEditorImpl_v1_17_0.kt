package ru.melonhell.umpa.core.data.entitymeta.editor.impl.other

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.other.UmpaAreaEffectCloudMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.UmpaEntityMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.enums.keyed.UmpaParticleType
import ru.melonhell.umpa.core.utils.UmpaColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAreaEffectCloudMetadataEditorImpl_v1_17_0 : UmpaAreaEffectCloudMetadataEditor,
    UmpaEntityMetadataEditorImpl_v1_17_0() {
    override fun readRadius(raw: UmpaRawEntityMetadata) = raw.readValue(8, Float::class.java)
    override fun writeRadius(raw: UmpaRawEntityMetadata, value: Float?) = raw.writeValue(8, value, Float::class.java)

    override fun readColor(raw: UmpaRawEntityMetadata) = raw.readValue(9, Int::class.java)?.let { UmpaColor(it) }
    override fun writeColor(raw: UmpaRawEntityMetadata, value: UmpaColor?) = raw.writeValue(9, value?.intValue, Int::class.java)

    override fun readWaiting(raw: UmpaRawEntityMetadata) = raw.readValue(10, Boolean::class.java)
    override fun writeWaiting(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(10, value, Boolean::class.java)

    override fun readParticle(raw: UmpaRawEntityMetadata) = raw.readValue(11, UmpaParticleType::class.java)
    override fun writeParticle(raw: UmpaRawEntityMetadata, value: UmpaParticleType?) = raw.writeValue(11, value, UmpaParticleType::class.java)
}
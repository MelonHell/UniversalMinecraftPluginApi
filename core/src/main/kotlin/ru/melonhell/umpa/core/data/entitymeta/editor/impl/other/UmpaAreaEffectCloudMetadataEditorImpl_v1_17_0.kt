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
    override fun readRadius(raw: UmpaRawEntityMetadata) = raw.getValue(8, Float::class.java)
    override fun writeRadius(raw: UmpaRawEntityMetadata, value: Float?) = raw.setValue(8, value)

    override fun readColor(raw: UmpaRawEntityMetadata) = raw.getValue(9, Int::class.java)?.let { UmpaColor(it) }
    override fun writeColor(raw: UmpaRawEntityMetadata, value: UmpaColor?) = raw.setValue(9, value?.intValue)

    override fun readWaiting(raw: UmpaRawEntityMetadata) = raw.getValue(10, Boolean::class.java)
    override fun writeWaiting(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(10, value)

    override fun readParticle(raw: UmpaRawEntityMetadata) = raw.getValue(11, UmpaParticleType::class.java)
    override fun writeParticle(raw: UmpaRawEntityMetadata, value: UmpaParticleType?) = raw.setValue(11, value)
}
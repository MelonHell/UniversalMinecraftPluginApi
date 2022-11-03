package ru.melonhell.umpa.core.data.entitymeta.editor.impl.vehicle

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.vehicle.UmpaBoatMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.UmpaEntityMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.vehicle.UmpaBoatMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaBoatMetadataEditorImpl_v1_17_0 : UmpaBoatMetadataEditor, UmpaEntityMetadataEditorImpl_v1_17_0() {
    private val types = UmpaBoatMetadata.Type.values()

    override fun readHurt(raw: UmpaRawEntityMetadata) = raw.getValue(8, Int::class.java)
    override fun writeHurt(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(8, value)

    override fun readHurtdir(raw: UmpaRawEntityMetadata) = raw.getValue(9, Int::class.java)
    override fun writeHurtdir(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(9, value)

    override fun readDamage(raw: UmpaRawEntityMetadata) = raw.getValue(10, Float::class.java)
    override fun writeDamage(raw: UmpaRawEntityMetadata, value: Float?) = raw.setValue(10, value)

    override fun readType(raw: UmpaRawEntityMetadata) = raw.getValue(11, Int::class.java)?.let { types[it] }
    override fun writeType(raw: UmpaRawEntityMetadata, value: UmpaBoatMetadata.Type?) = raw.setValue(11, value?.ordinal)

    override fun readPaddleLeft(raw: UmpaRawEntityMetadata) = raw.getValue(12, Boolean::class.java)
    override fun writePaddleLeft(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(12, value)

    override fun readPaddleRight(raw: UmpaRawEntityMetadata) = raw.getValue(13, Boolean::class.java)
    override fun writePaddleRight(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(13, value)

    override fun readBubbleTime(raw: UmpaRawEntityMetadata) = raw.getValue(14, Int::class.java)
    override fun writeBubbleTime(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(14, value)
}
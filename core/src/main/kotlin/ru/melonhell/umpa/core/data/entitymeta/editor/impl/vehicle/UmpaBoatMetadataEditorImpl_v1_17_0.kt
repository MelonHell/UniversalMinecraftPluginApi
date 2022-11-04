package ru.melonhell.umpa.core.data.entitymeta.editor.impl.vehicle

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.vehicle.UmpaBoatMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.UmpaEntityMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.vehicle.UmpaBoatMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaBoatMetadataEditorImpl_v1_17_0 : UmpaBoatMetadataEditor, UmpaEntityMetadataEditorImpl_v1_17_0() {
    private val types = UmpaBoatMetadata.Type.values()

    override fun readHurt(raw: UmpaRawEntityMetadata) = raw.readValue(8, Int::class.java)
    override fun writeHurt(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(8, value, Int::class.java)

    override fun readHurtdir(raw: UmpaRawEntityMetadata) = raw.readValue(9, Int::class.java)
    override fun writeHurtdir(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(9, value, Int::class.java)

    override fun readDamage(raw: UmpaRawEntityMetadata) = raw.readValue(10, Float::class.java)
    override fun writeDamage(raw: UmpaRawEntityMetadata, value: Float?) = raw.writeValue(10, value, Float::class.java)

    override fun readType(raw: UmpaRawEntityMetadata) = raw.readValue(11, Int::class.java)?.let { types[it] }
    override fun writeType(raw: UmpaRawEntityMetadata, value: UmpaBoatMetadata.Type?) = raw.writeValue(11, value?.ordinal, Int::class.java)

    override fun readPaddleLeft(raw: UmpaRawEntityMetadata) = raw.readValue(12, Boolean::class.java)
    override fun writePaddleLeft(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(12, value, Boolean::class.java)

    override fun readPaddleRight(raw: UmpaRawEntityMetadata) = raw.readValue(13, Boolean::class.java)
    override fun writePaddleRight(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(13, value, Boolean::class.java)

    override fun readBubbleTime(raw: UmpaRawEntityMetadata) = raw.readValue(14, Int::class.java)
    override fun writeBubbleTime(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(14, value, Int::class.java)
}
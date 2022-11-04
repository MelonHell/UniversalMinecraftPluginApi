package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractMinecartMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.UmpaEntityMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAbstractMinecartMetadataEditorImpl_v1_17_0 : UmpaAbstractMinecartMetadataEditor,
    UmpaEntityMetadataEditorImpl_v1_17_0() {
    override fun readHurt(raw: UmpaRawEntityMetadata) = raw.readValue(8, Int::class.java)
    override fun writeHurt(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(8, value, Int::class.java)

    override fun readHurtdir(raw: UmpaRawEntityMetadata) = raw.readValue(9, Int::class.java)
    override fun writeHurtdir(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(9, value, Int::class.java)

    override fun readDamage(raw: UmpaRawEntityMetadata) = raw.readValue(10, Float::class.java)
    override fun writeDamage(raw: UmpaRawEntityMetadata, value: Float?) = raw.writeValue(10, value, Float::class.java)

    override fun readDisplayBlock(raw: UmpaRawEntityMetadata) = raw.readValue(11, Int::class.java)
    override fun writeDisplayBlock(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(11, value, Int::class.java)

    override fun readDisplayOffset(raw: UmpaRawEntityMetadata) = raw.readValue(12, Int::class.java)
    override fun writeDisplayOffset(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(12, value, Int::class.java)

    override fun readCustomDisplay(raw: UmpaRawEntityMetadata) = raw.readValue(13, Boolean::class.java)
    override fun writeCustomDisplay(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(13, value, Boolean::class.java)
}
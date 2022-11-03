package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractMinecartMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.UmpaEntityMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAbstractMinecartMetadataEditorImpl_v1_17_0 : UmpaAbstractMinecartMetadataEditor,
    UmpaEntityMetadataEditorImpl_v1_17_0() {
    override fun readHurt(raw: UmpaRawEntityMetadata) = raw.getValue(8, Int::class.java)
    override fun writeHurt(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(8, value)

    override fun readHurtdir(raw: UmpaRawEntityMetadata) = raw.getValue(9, Int::class.java)
    override fun writeHurtdir(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(9, value)

    override fun readDamage(raw: UmpaRawEntityMetadata) = raw.getValue(10, Float::class.java)
    override fun writeDamage(raw: UmpaRawEntityMetadata, value: Float?) = raw.setValue(10, value)

    override fun readDisplayBlock(raw: UmpaRawEntityMetadata) = raw.getValue(11, Int::class.java)
    override fun writeDisplayBlock(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(11, value)

    override fun readDisplayOffset(raw: UmpaRawEntityMetadata) = raw.getValue(12, Int::class.java)
    override fun writeDisplayOffset(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(12, value)

    override fun readCustomDisplay(raw: UmpaRawEntityMetadata) = raw.getValue(13, Boolean::class.java)
    override fun writeCustomDisplay(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(13, value)
}
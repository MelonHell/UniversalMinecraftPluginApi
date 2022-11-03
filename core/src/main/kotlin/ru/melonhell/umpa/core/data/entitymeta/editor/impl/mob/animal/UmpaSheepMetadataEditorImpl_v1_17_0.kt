package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaSheepMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaSheepMetadataEditorImpl_v1_17_0 : UmpaSheepMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    private val dyeColors = UmpaDyeColor.values()

    override fun readColor(raw: UmpaRawEntityMetadata) = null // = raw.getValue(1, UmpaDyeColor::class.java)
    override fun writeColor(raw: UmpaRawEntityMetadata, value: UmpaDyeColor?) = Unit // = raw.setValue(1, value)

    override fun readSheared(raw: UmpaRawEntityMetadata) = raw.getFlag(17, 0)
    override fun writeSheared(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(17, 0, value)

    private fun getColor(flag: Byte) = dyeColors[(flag.toInt() and 15)]
    private fun setColor(flag: Byte, dyeColor: UmpaDyeColor): Byte =
        (flag.toInt() and 240 or (dyeColor.ordinal and 15)).toByte()
}
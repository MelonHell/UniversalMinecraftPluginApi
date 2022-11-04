package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaSheepMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaSheepMetadataEditorImpl_v1_17_0 : UmpaSheepMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    private val dyeColors = UmpaDyeColor.values()

    override fun readColor(raw: UmpaRawEntityMetadata) = raw.readValue(17, Byte::class.java)?.let { getColor(it) }

    override fun writeColor(raw: UmpaRawEntityMetadata, value: UmpaDyeColor?) {
        if (value != null) raw.writeValue(17, setColor(raw.readValue(17, Byte::class.java) ?: 0, value), Byte::class.java)
    }

    override fun readSheared(raw: UmpaRawEntityMetadata) = raw.readFlag(17, 4)
    override fun writeSheared(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(17, 4, value)

    private fun getColor(flag: Byte) = dyeColors[(flag.toInt() and 15)]
    private fun setColor(flag: Byte, dyeColor: UmpaDyeColor): Byte =
        (flag.toInt() and 240 or (dyeColor.ordinal and 15)).toByte()
}
package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaCatMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaTamableAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaCatMetadata
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaCatMetadataEditorImpl_v1_17_0 : UmpaCatMetadataEditor, UmpaTamableAnimalMetadataEditorImpl_v1_17_0() {
    private val dyeColors = UmpaDyeColor.values()

    override fun readType(raw: UmpaRawEntityMetadata) = raw.readValue(19, UmpaCatMetadata.Type::class.java)
    override fun writeType(raw: UmpaRawEntityMetadata, value: UmpaCatMetadata.Type?) = raw.writeValue(19, value, UmpaCatMetadata.Type::class.java)

    override fun readLying(raw: UmpaRawEntityMetadata) = raw.readValue(20, Boolean::class.java)
    override fun writeLying(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(20, value, Boolean::class.java)

    override fun readRelaxed(raw: UmpaRawEntityMetadata) = raw.readValue(21, Boolean::class.java)
    override fun writeRelaxed(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(21, value, Boolean::class.java)

    override fun readCollarColor(raw: UmpaRawEntityMetadata) = raw.readValue(22, Int::class.java)?.let { dyeColors[it] }
    override fun writeCollarColor(raw: UmpaRawEntityMetadata, value: UmpaDyeColor?) = raw.writeValue(22, value?.ordinal, Int::class.java)
}
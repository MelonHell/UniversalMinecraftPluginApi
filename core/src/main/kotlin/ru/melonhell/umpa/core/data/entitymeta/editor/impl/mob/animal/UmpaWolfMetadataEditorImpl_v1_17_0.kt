package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaWolfMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaTamableAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaWolfMetadataEditorImpl_v1_17_0 : UmpaWolfMetadataEditor, UmpaTamableAnimalMetadataEditorImpl_v1_17_0() {
    private val dyeColors = UmpaDyeColor.values()

    override fun readInterested(raw: UmpaRawEntityMetadata) = raw.readValue(19, Boolean::class.java)
    override fun writeInterested(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(19, value, Boolean::class.java)

    override fun readCollarColor(raw: UmpaRawEntityMetadata) = raw.readValue(20, Int::class.java)?.let { dyeColors[it] }
    override fun writeCollarColor(raw: UmpaRawEntityMetadata, value: UmpaDyeColor?) = raw.writeValue(20, value?.ordinal, Int::class.java)

    override fun readRemainingAngerTime(raw: UmpaRawEntityMetadata) = raw.readValue(21, Int::class.java)
    override fun writeRemainingAngerTime(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(21, value, Int::class.java)
}
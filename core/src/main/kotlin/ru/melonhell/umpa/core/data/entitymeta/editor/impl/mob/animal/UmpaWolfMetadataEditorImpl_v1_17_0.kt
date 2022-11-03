package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaWolfMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaTamableAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaWolfMetadataEditorImpl_v1_17_0 : UmpaWolfMetadataEditor, UmpaTamableAnimalMetadataEditorImpl_v1_17_0() {
    private val dyeColors = UmpaDyeColor.values()

    override fun readInterested(raw: UmpaRawEntityMetadata) = raw.getValue(19, Boolean::class.java)
    override fun writeInterested(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(19, value)

    override fun readCollarColor(raw: UmpaRawEntityMetadata) = raw.getValue(20, Int::class.java)?.let { dyeColors[it] }
    override fun writeCollarColor(raw: UmpaRawEntityMetadata, value: UmpaDyeColor?) = raw.setValue(20, value?.ordinal)

    override fun readRemainingAngerTime(raw: UmpaRawEntityMetadata) = raw.getValue(21, Int::class.java)
    override fun writeRemainingAngerTime(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(21, value)
}
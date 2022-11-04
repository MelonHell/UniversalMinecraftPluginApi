package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal.water

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.water.UmpaTropicalFishMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractSchoolingFishMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water.UmpaTropicalFishMetadata
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaTropicalFishMetadataEditorImpl_v1_17_0 :
    UmpaTropicalFishMetadataEditor,
    UmpaAbstractSchoolingFishMetadataEditorImpl_v1_17_0() {
    override fun readPattern(raw: UmpaRawEntityMetadata) = null // = raw.getValue(1, UmpaTropicalFishMetadata.Pattern::class.java)
    override fun writePattern(raw: UmpaRawEntityMetadata, value: UmpaTropicalFishMetadata.Pattern?) = Unit // = raw.setValue(1, value, UmpaTropicalFishMetadata.Pattern::class.java)

    override fun readBodyColor(raw: UmpaRawEntityMetadata) = null // = raw.getValue(1, UmpaDyeColor::class.java)
    override fun writeBodyColor(raw: UmpaRawEntityMetadata, value: UmpaDyeColor?) = Unit // = raw.setValue(1, value, UmpaDyeColor::class.java)

    override fun readPatternColor(raw: UmpaRawEntityMetadata) = null // = raw.getValue(1, UmpaDyeColor::class.java)
    override fun writePatternColor(raw: UmpaRawEntityMetadata, value: UmpaDyeColor?) = Unit // = raw.setValue(1, value, UmpaDyeColor::class.java)
}
package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaLlamaMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractChestedHorseMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaLlamaMetadata
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaLlamaMetadataEditorImpl_v1_17_0 : UmpaLlamaMetadataEditor,
    UmpaAbstractChestedHorseMetadataEditorImpl_v1_17_0() {
    private val types = UmpaLlamaMetadata.Type.values()
    private val dyeColors = UmpaDyeColor.values()

    override fun readStrength(raw: UmpaRawEntityMetadata) = raw.getValue(20, Int::class.java)
    override fun writeStrength(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(20, value)

    override fun readCarpetColor(raw: UmpaRawEntityMetadata) =
        raw.getValue(21, Int::class.java)?.let { if (it == -1) Optional.empty() else Optional.of(dyeColors[it]) }

    override fun writeCarpetColor(raw: UmpaRawEntityMetadata, value: Optional<UmpaDyeColor>?) =
        raw.setValue(21, value?.map { it.ordinal }?.orElse(-1))

    override fun readType(raw: UmpaRawEntityMetadata) = raw.getValue(22, Int::class.java)?.let { types[it] }
    override fun writeType(raw: UmpaRawEntityMetadata, value: UmpaLlamaMetadata.Type?) =
        raw.setValue(22, value?.ordinal)
}
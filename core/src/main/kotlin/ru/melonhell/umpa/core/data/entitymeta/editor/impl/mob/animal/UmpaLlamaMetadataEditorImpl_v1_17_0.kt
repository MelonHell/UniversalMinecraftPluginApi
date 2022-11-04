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

    override fun readStrength(raw: UmpaRawEntityMetadata) = raw.readValue(20, Int::class.java)
    override fun writeStrength(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(20, value, Int::class.java)

    override fun readCarpetColor(raw: UmpaRawEntityMetadata) =
        raw.readValue(21, Int::class.java)?.let { if (it == -1) Optional.empty() else Optional.of(dyeColors[it]) }

    override fun writeCarpetColor(raw: UmpaRawEntityMetadata, value: Optional<UmpaDyeColor>?) =
        raw.writeValue(21, value?.map { it.ordinal }?.orElse(-1), Int::class.java)

    override fun readType(raw: UmpaRawEntityMetadata) = raw.readValue(22, Int::class.java)?.let { types[it] }
    override fun writeType(raw: UmpaRawEntityMetadata, value: UmpaLlamaMetadata.Type?) =
        raw.writeValue(22, value?.ordinal, Int::class.java)
}
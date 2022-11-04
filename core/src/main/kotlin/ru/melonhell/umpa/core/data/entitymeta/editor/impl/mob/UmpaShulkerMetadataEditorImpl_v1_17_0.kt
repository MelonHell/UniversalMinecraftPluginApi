package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.UmpaShulkerMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractGolemMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.utils.UmpaDirection
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaShulkerMetadataEditorImpl_v1_17_0 : UmpaShulkerMetadataEditor,
    UmpaAbstractGolemMetadataEditorImpl_v1_17_0() {
    private val dyeColors = UmpaDyeColor.values()

    override fun readAttachFace(raw: UmpaRawEntityMetadata) = raw.readValue(16, UmpaDirection::class.java)
    override fun writeAttachFace(raw: UmpaRawEntityMetadata, value: UmpaDirection?) = raw.writeValue(16, value, UmpaDirection::class.java)

    override fun readAttachPos(raw: UmpaRawEntityMetadata) = raw.readValue(17, UmpaBlockPos::class.java)
    override fun writeAttachPos(raw: UmpaRawEntityMetadata, value: UmpaBlockPos?) = raw.writeValue(17, value, UmpaBlockPos::class.java)

    override fun readPeek(raw: UmpaRawEntityMetadata) = raw.readValue(18, Byte::class.java)?.toInt()
    override fun writePeek(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(18, value?.toByte(), Byte::class.java)

    override fun readCustomColor(raw: UmpaRawEntityMetadata) = raw.readValue(19, Byte::class.java)?.toInt()
        ?.let { if (it == 16) Optional.empty() else Optional.of(dyeColors[it]) }

    override fun writeCustomColor(raw: UmpaRawEntityMetadata, value: Optional<UmpaDyeColor>?) =
        raw.writeValue(19, value?.map { it.ordinal }?.orElse(16)?.toByte(), Byte::class.java)
}
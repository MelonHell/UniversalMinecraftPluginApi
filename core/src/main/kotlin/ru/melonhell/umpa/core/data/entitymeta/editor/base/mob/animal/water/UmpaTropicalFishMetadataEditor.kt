package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractSchoolingFishMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water.UmpaTropicalFishMetadata
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaTropicalFishMetadataEditor : UmpaAbstractSchoolingFishMetadataEditor {

    fun readPattern(raw: UmpaRawEntityMetadata): UmpaTropicalFishMetadata.Pattern?
    fun writePattern(raw: UmpaRawEntityMetadata, value: UmpaTropicalFishMetadata.Pattern?)

    fun readBodyColor(raw: UmpaRawEntityMetadata): UmpaDyeColor?
    fun writeBodyColor(raw: UmpaRawEntityMetadata, value: UmpaDyeColor?)

    fun readPatternColor(raw: UmpaRawEntityMetadata): UmpaDyeColor?
    fun writePatternColor(raw: UmpaRawEntityMetadata, value: UmpaDyeColor?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaTropicalFishMetadata =
        UmpaTropicalFishMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaTropicalFishMetadata) return
        readPattern(raw)?.let { meta.pattern = it }
        readBodyColor(raw)?.let { meta.bodyColor = it }
        readPatternColor(raw)?.let { meta.patternColor = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaTropicalFishMetadata) return
        writePattern(raw, meta.pattern)
        writeBodyColor(raw, meta.bodyColor)
        writePatternColor(raw, meta.patternColor)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaTropicalFishMetadata::class.java
}
package ru.melonhell.umpa.core.data.entitymeta.editor.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaArrowMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractArrowMetadataEditor
import ru.melonhell.umpa.core.utils.UmpaColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaArrowMetadataEditor : UmpaAbstractArrowMetadataEditor {

    fun readEffectColor(raw: UmpaRawEntityMetadata): Optional<UmpaColor>?
    fun writeEffectColor(raw: UmpaRawEntityMetadata, value: Optional<UmpaColor>?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaArrowMetadata =
        UmpaArrowMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaArrowMetadata) return
        readEffectColor(raw)?.let { meta.effectColor = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaArrowMetadata) return
        writeEffectColor(raw, meta.effectColor)
    }
}
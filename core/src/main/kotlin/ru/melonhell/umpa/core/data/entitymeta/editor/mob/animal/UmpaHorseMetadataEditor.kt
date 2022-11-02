package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaHorseMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractHorseMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaHorseMetadataEditor : UmpaAbstractHorseMetadataEditor {

    fun readBaseColor(raw: UmpaRawEntityMetadata): UmpaHorseMetadata.Color?
    fun writeBaseColor(raw: UmpaRawEntityMetadata, value: UmpaHorseMetadata.Color?)

    fun readMarkings(raw: UmpaRawEntityMetadata): UmpaHorseMetadata.Marking?
    fun writeMarkings(raw: UmpaRawEntityMetadata, value: UmpaHorseMetadata.Marking?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaHorseMetadata =
        UmpaHorseMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaHorseMetadata) return
        readBaseColor(raw)?.let { meta.baseColor = it }
        readMarkings(raw)?.let { meta.markings = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaHorseMetadata) return
        writeBaseColor(raw, meta.baseColor)
        writeMarkings(raw, meta.markings)
    }
}
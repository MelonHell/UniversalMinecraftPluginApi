package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractHorseMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaHorseMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

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

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaHorseMetadata::class.java
}
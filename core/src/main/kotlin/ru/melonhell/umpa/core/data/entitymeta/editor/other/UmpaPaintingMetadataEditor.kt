package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaPaintingMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaHangingEntityMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaPaintingMetadataEditor : UmpaHangingEntityMetadataEditor {

    fun readType(raw: UmpaRawEntityMetadata): UmpaPaintingMetadata.Type?
    fun writeType(raw: UmpaRawEntityMetadata, value: UmpaPaintingMetadata.Type?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaPaintingMetadata =
        UmpaPaintingMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaPaintingMetadata) return
        readType(raw)?.let { meta.type = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaPaintingMetadata) return
        writeType(raw, meta.type)
    }
}
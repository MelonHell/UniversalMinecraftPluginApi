package ru.melonhell.umpa.core.data.entitymeta.editor.base.other

import ru.melonhell.umpa.core.data.entitymeta.editor.base.UmpaEntityMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaPrimedTntMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaPrimedTntMetadataEditor : UmpaEntityMetadataEditor {

    fun readFuse(raw: UmpaRawEntityMetadata): Int?
    fun writeFuse(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaPrimedTntMetadata =
        UmpaPrimedTntMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaPrimedTntMetadata) return
        readFuse(raw)?.let { meta.fuse = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaPrimedTntMetadata) return
        writeFuse(raw, meta.fuse)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaPrimedTntMetadata::class.java
}
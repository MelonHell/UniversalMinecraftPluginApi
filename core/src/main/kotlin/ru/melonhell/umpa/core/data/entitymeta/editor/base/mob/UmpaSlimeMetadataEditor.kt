package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaMobMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.UmpaSlimeMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaSlimeMetadataEditor : UmpaMobMetadataEditor {

    fun readSize(raw: UmpaRawEntityMetadata): Int?
    fun writeSize(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSlimeMetadata =
        UmpaSlimeMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaSlimeMetadata) return
        readSize(raw)?.let { meta.size = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaSlimeMetadata) return
        writeSize(raw, meta.size)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaSlimeMetadata::class.java
}
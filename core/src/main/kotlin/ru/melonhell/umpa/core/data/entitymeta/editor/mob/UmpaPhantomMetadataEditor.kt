package ru.melonhell.umpa.core.data.entitymeta.editor.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.UmpaPhantomMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaFlyingMobMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaPhantomMetadataEditor : UmpaFlyingMobMetadataEditor {

    fun readSize(raw: UmpaRawEntityMetadata): Int?
    fun writeSize(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaPhantomMetadata =
        UmpaPhantomMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaPhantomMetadata) return
        readSize(raw)?.let { meta.size = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaPhantomMetadata) return
        writeSize(raw, meta.size)
    }
}
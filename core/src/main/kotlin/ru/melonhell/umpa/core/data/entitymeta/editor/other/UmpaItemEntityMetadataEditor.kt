package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaItemEntityMetadata
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaItemEntityMetadataEditor : ru.melonhell.umpa.core.data.entitymeta.editor.UmpaEntityMetadataEditor {

    fun readItem(raw: UmpaRawEntityMetadata): Optional<UmpaItemStack>?
    fun writeItem(raw: UmpaRawEntityMetadata, value: Optional<UmpaItemStack>?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaItemEntityMetadata =
        UmpaItemEntityMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaItemEntityMetadata) return
        readItem(raw)?.let { meta.item = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaItemEntityMetadata) return
        writeItem(raw, meta.item)
    }
}
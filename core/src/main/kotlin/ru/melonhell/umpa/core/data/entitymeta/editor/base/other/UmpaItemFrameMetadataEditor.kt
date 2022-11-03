package ru.melonhell.umpa.core.data.entitymeta.editor.base.other

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaHangingEntityMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaItemFrameMetadata
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaItemFrameMetadataEditor : UmpaHangingEntityMetadataEditor {

    fun readItem(raw: UmpaRawEntityMetadata): Optional<UmpaItemStack>?
    fun writeItem(raw: UmpaRawEntityMetadata, value: Optional<UmpaItemStack>?)

    fun readItemRotation(raw: UmpaRawEntityMetadata): Int?
    fun writeItemRotation(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaItemFrameMetadata =
        UmpaItemFrameMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaItemFrameMetadata) return
        readItem(raw)?.let { meta.item = it }
        readItemRotation(raw)?.let { meta.itemRotation = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaItemFrameMetadata) return
        writeItem(raw, meta.item)
        writeItemRotation(raw, meta.itemRotation)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaItemFrameMetadata::class.java
}
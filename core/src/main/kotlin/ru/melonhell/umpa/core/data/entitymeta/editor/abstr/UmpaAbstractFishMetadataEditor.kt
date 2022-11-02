package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractFishMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAbstractFishMetadataEditor : UmpaWaterAnimalMetadataEditor {

    fun readFromBucket(raw: UmpaRawEntityMetadata): Boolean?
    fun writeFromBucket(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAbstractFishMetadata =
        UmpaAbstractFishMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaAbstractFishMetadata) return
        readFromBucket(raw)?.let { meta.fromBucket = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaAbstractFishMetadata) return
        writeFromBucket(raw, meta.fromBucket)
    }
}
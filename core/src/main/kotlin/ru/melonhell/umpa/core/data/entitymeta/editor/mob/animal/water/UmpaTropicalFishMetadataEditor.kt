package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water.UmpaTropicalFishMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractSchoolingFishMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaTropicalFishMetadataEditor : UmpaAbstractSchoolingFishMetadataEditor {

    fun readTypeVariant(raw: UmpaRawEntityMetadata): Int?
    fun writeTypeVariant(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaTropicalFishMetadata =
        UmpaTropicalFishMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaTropicalFishMetadata) return
        readTypeVariant(raw)?.let { meta.typeVariant = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaTropicalFishMetadata) return
        writeTypeVariant(raw, meta.typeVariant)
    }
}
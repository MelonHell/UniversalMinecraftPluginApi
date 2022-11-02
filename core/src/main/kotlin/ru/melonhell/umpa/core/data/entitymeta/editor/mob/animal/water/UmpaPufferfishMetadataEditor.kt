package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water.UmpaPufferfishMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractFishMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaPufferfishMetadataEditor : UmpaAbstractFishMetadataEditor {

    fun readPuffState(raw: UmpaRawEntityMetadata): Int?
    fun writePuffState(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaPufferfishMetadata =
        UmpaPufferfishMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaPufferfishMetadata) return
        readPuffState(raw)?.let { meta.puffState = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaPufferfishMetadata) return
        writePuffState(raw, meta.puffState)
    }
}
package ru.melonhell.umpa.core.data.entitymeta.editor.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.UmpaBatMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAmbientCreatureMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaBatMetadataEditor : UmpaAmbientCreatureMetadataEditor {

    fun readHanging(raw: UmpaRawEntityMetadata): Boolean?
    fun writeHanging(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaBatMetadata = UmpaBatMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaBatMetadata) return
        readHanging(raw)?.let { meta.hanging = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaBatMetadata) return
        writeHanging(raw, meta.hanging)
    }
}
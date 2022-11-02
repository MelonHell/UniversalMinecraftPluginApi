package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaBeeMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAnimalMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaBeeMetadataEditor : UmpaAnimalMetadataEditor {

    fun readAngry(raw: UmpaRawEntityMetadata): Boolean?
    fun writeAngry(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readHasStung(raw: UmpaRawEntityMetadata): Boolean?
    fun writeHasStung(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readHasNectar(raw: UmpaRawEntityMetadata): Boolean?
    fun writeHasNectar(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readRemainingAngerTime(raw: UmpaRawEntityMetadata): Int?
    fun writeRemainingAngerTime(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaBeeMetadata = UmpaBeeMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaBeeMetadata) return
        readAngry(raw)?.let { meta.angry = it }
        readHasStung(raw)?.let { meta.hasStung = it }
        readHasNectar(raw)?.let { meta.hasNectar = it }
        readRemainingAngerTime(raw)?.let { meta.remainingAngerTime = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaBeeMetadata) return
        writeAngry(raw, meta.angry)
        writeHasStung(raw, meta.hasStung)
        writeHasNectar(raw, meta.hasNectar)
        writeRemainingAngerTime(raw, meta.remainingAngerTime)
    }
}
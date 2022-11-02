package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaStriderMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAnimalMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaStriderMetadataEditor : UmpaAnimalMetadataEditor {

    fun readBoostTime(raw: UmpaRawEntityMetadata): Int?
    fun writeBoostTime(raw: UmpaRawEntityMetadata, value: Int?)

    fun readSuffocating(raw: UmpaRawEntityMetadata): Boolean?
    fun writeSuffocating(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readSaddle(raw: UmpaRawEntityMetadata): Boolean?
    fun writeSaddle(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaStriderMetadata =
        UmpaStriderMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaStriderMetadata) return
        readBoostTime(raw)?.let { meta.boostTime = it }
        readSuffocating(raw)?.let { meta.suffocating = it }
        readSaddle(raw)?.let { meta.saddle = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaStriderMetadata) return
        writeBoostTime(raw, meta.boostTime)
        writeSuffocating(raw, meta.suffocating)
        writeSaddle(raw, meta.saddle)
    }
}
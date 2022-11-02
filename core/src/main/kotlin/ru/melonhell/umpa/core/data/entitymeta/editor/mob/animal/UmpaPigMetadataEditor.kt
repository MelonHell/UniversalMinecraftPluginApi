package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaPigMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAnimalMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaPigMetadataEditor : UmpaAnimalMetadataEditor {

    fun readHasSaddle(raw: UmpaRawEntityMetadata): Boolean?
    fun writeHasSaddle(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readBoostTime(raw: UmpaRawEntityMetadata): Int?
    fun writeBoostTime(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaPigMetadata = UmpaPigMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaPigMetadata) return
        readHasSaddle(raw)?.let { meta.hasSaddle = it }
        readBoostTime(raw)?.let { meta.boostTime = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaPigMetadata) return
        writeHasSaddle(raw, meta.hasSaddle)
        writeBoostTime(raw, meta.boostTime)
    }
}
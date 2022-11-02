package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMobMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaMobMetadataEditor : UmpaLivingEntityMetadataEditor {

    fun readNoAi(raw: UmpaRawEntityMetadata): Boolean?
    fun writeNoAi(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readLeftHanded(raw: UmpaRawEntityMetadata): Boolean?
    fun writeLeftHanded(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readAggressive(raw: UmpaRawEntityMetadata): Boolean?
    fun writeAggressive(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMobMetadata = UmpaMobMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaMobMetadata) return
        readNoAi(raw)?.let { meta.noAi = it }
        readLeftHanded(raw)?.let { meta.leftHanded = it }
        readAggressive(raw)?.let { meta.aggressive = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaMobMetadata) return
        writeNoAi(raw, meta.noAi)
        writeLeftHanded(raw, meta.leftHanded)
        writeAggressive(raw, meta.aggressive)
    }
}
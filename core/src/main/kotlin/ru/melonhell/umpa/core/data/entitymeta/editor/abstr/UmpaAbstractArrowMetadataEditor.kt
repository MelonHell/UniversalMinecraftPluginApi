package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractArrowMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAbstractArrowMetadataEditor : UmpaProjectileMetadataEditor {

    fun readCritical(raw: UmpaRawEntityMetadata): Boolean?
    fun writeCritical(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readNoclip(raw: UmpaRawEntityMetadata): Boolean?
    fun writeNoclip(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readPierceLevel(raw: UmpaRawEntityMetadata): Int?
    fun writePierceLevel(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAbstractArrowMetadata =
        UmpaAbstractArrowMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaAbstractArrowMetadata) return
        readCritical(raw)?.let { meta.critical = it }
        readNoclip(raw)?.let { meta.noclip = it }
        readPierceLevel(raw)?.let { meta.pierceLevel = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaAbstractArrowMetadata) return
        writeCritical(raw, meta.critical)
        writeNoclip(raw, meta.noclip)
        writePierceLevel(raw, meta.pierceLevel)
    }
}
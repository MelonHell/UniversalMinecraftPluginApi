package ru.melonhell.umpa.core.data.entitymeta.editor.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.UmpaEnderDragonMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaMobMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaEnderDragonMetadataEditor : UmpaMobMetadataEditor {

    fun readPhase(raw: UmpaRawEntityMetadata): UmpaEnderDragonMetadata.Phase?
    fun writePhase(raw: UmpaRawEntityMetadata, value: UmpaEnderDragonMetadata.Phase?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaEnderDragonMetadata =
        UmpaEnderDragonMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaEnderDragonMetadata) return
        readPhase(raw)?.let { meta.phase = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaEnderDragonMetadata) return
        writePhase(raw, meta.phase)
    }
}
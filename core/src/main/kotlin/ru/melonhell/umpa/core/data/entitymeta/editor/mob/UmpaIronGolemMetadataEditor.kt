package ru.melonhell.umpa.core.data.entitymeta.editor.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.UmpaIronGolemMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractGolemMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaIronGolemMetadataEditor : UmpaAbstractGolemMetadataEditor {

    fun readPlayerCreated(raw: UmpaRawEntityMetadata): Boolean?
    fun writePlayerCreated(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaIronGolemMetadata =
        UmpaIronGolemMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaIronGolemMetadata) return
        readPlayerCreated(raw)?.let { meta.playerCreated = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaIronGolemMetadata) return
        writePlayerCreated(raw, meta.playerCreated)
    }
}
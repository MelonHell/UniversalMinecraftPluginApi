package ru.melonhell.umpa.core.data.entitymeta.editor.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.UmpaAllayMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaPathfinderMobMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaAllayMetadataEditor : UmpaPathfinderMobMetadataEditor {

    fun readDancing(raw: UmpaRawEntityMetadata): Boolean?
    fun writeDancing(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readCanDuplicate(raw: UmpaRawEntityMetadata): Boolean?
    fun writeCanDuplicate(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAllayMetadata =
        UmpaAllayMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaAllayMetadata) return
        readDancing(raw)?.let { meta.dancing = it }
        readCanDuplicate(raw)?.let { meta.canDuplicate = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaAllayMetadata) return
        writeDancing(raw, meta.dancing)
        writeCanDuplicate(raw, meta.canDuplicate)
    }
}
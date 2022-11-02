package ru.melonhell.umpa.core.data.entitymeta.editor.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaCreeperMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaMonsterMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaCreeperMetadataEditor : UmpaMonsterMetadataEditor {

    fun readSwellDir(raw: UmpaRawEntityMetadata): UmpaCreeperMetadata.State?
    fun writeSwellDir(raw: UmpaRawEntityMetadata, value: UmpaCreeperMetadata.State?)

    fun readIsCharged(raw: UmpaRawEntityMetadata): Boolean?
    fun writeIsCharged(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readIsIgnited(raw: UmpaRawEntityMetadata): Boolean?
    fun writeIsIgnited(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaCreeperMetadata =
        UmpaCreeperMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaCreeperMetadata) return
        readSwellDir(raw)?.let { meta.swellDir = it }
        readIsCharged(raw)?.let { meta.isCharged = it }
        readIsIgnited(raw)?.let { meta.isIgnited = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaCreeperMetadata) return
        writeSwellDir(raw, meta.swellDir)
        writeIsCharged(raw, meta.isCharged)
        writeIsIgnited(raw, meta.isIgnited)
    }
}
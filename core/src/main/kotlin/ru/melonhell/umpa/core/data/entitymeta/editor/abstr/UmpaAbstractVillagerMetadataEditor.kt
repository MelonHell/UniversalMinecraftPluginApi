package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractVillagerMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAbstractVillagerMetadataEditor : UmpaAgeableMobMetadataEditor {

    fun readUnhappyCounter(raw: UmpaRawEntityMetadata): Int?
    fun writeUnhappyCounter(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAbstractVillagerMetadata =
        UmpaAbstractVillagerMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaAbstractVillagerMetadata) return
        readUnhappyCounter(raw)?.let { meta.unhappyCounter = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaAbstractVillagerMetadata) return
        writeUnhappyCounter(raw, meta.unhappyCounter)
    }
}
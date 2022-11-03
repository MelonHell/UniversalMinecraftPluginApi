package ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaRaiderMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaRaiderMetadataEditor : UmpaPatrollingMonsterMetadataEditor {

    fun readCelebrating(raw: UmpaRawEntityMetadata): Boolean?
    fun writeCelebrating(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaRaiderMetadata =
        UmpaRaiderMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaRaiderMetadata) return
        readCelebrating(raw)?.let { meta.celebrating = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaRaiderMetadata) return
        writeCelebrating(raw, meta.celebrating)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaRaiderMetadata::class.java
}
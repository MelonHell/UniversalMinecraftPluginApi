package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAgeableMobMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAgeableMobMetadataEditor : UmpaPathfinderMobMetadataEditor {

    fun readBaby(raw: UmpaRawEntityMetadata): Boolean?
    fun writeBaby(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAgeableMobMetadata =
        UmpaAgeableMobMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaAgeableMobMetadata) return
        readBaby(raw)?.let { meta.baby = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaAgeableMobMetadata) return
        writeBaby(raw, meta.baby)
    }
}
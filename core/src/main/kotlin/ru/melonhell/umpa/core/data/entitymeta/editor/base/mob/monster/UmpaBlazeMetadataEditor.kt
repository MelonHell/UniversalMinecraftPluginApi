package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaMonsterMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaBlazeMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaBlazeMetadataEditor : UmpaMonsterMetadataEditor {

    fun readBlazeOnFire(raw: UmpaRawEntityMetadata): Boolean?
    fun writeBlazeOnFire(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaBlazeMetadata =
        UmpaBlazeMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaBlazeMetadata) return
        readBlazeOnFire(raw)?.let { meta.blazeOnFire = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaBlazeMetadata) return
        writeBlazeOnFire(raw, meta.blazeOnFire)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaBlazeMetadata::class.java
}
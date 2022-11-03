package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAnimalMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaPolarBearMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaPolarBearMetadataEditor : UmpaAnimalMetadataEditor {

    fun readStanding(raw: UmpaRawEntityMetadata): Boolean?
    fun writeStanding(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaPolarBearMetadata =
        UmpaPolarBearMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaPolarBearMetadata) return
        readStanding(raw)?.let { meta.standing = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaPolarBearMetadata) return
        writeStanding(raw, meta.standing)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaPolarBearMetadata::class.java
}
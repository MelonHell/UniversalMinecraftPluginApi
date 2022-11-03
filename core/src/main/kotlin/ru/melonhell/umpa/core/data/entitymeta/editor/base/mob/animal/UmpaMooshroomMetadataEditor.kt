package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaMooshroomMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaMooshroomMetadataEditor : UmpaCowMetadataEditor {

    fun readType(raw: UmpaRawEntityMetadata): UmpaMooshroomMetadata.Type?
    fun writeType(raw: UmpaRawEntityMetadata, value: UmpaMooshroomMetadata.Type?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMooshroomMetadata =
        UmpaMooshroomMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaMooshroomMetadata) return
        readType(raw)?.let { meta.type = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaMooshroomMetadata) return
        writeType(raw, meta.type)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaMooshroomMetadata::class.java
}
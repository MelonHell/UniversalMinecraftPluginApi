package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaShoulderRidingEntityMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaParrotMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaParrotMetadataEditor : UmpaShoulderRidingEntityMetadataEditor {

    fun readType(raw: UmpaRawEntityMetadata): UmpaParrotMetadata.Type?
    fun writeType(raw: UmpaRawEntityMetadata, value: UmpaParrotMetadata.Type?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaParrotMetadata =
        UmpaParrotMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaParrotMetadata) return
        readType(raw)?.let { meta.type = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaParrotMetadata) return
        writeType(raw, meta.type)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaParrotMetadata::class.java
}
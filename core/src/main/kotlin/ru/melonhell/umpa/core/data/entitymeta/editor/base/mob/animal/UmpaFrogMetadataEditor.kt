package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAnimalMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaFrogMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaFrogMetadataEditor : UmpaAnimalMetadataEditor {

    fun readType(raw: UmpaRawEntityMetadata): UmpaFrogMetadata.Type?
    fun writeType(raw: UmpaRawEntityMetadata, value: UmpaFrogMetadata.Type?)

    fun readTongueTargetId(raw: UmpaRawEntityMetadata): OptionalInt?
    fun writeTongueTargetId(raw: UmpaRawEntityMetadata, value: OptionalInt?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaFrogMetadata = UmpaFrogMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaFrogMetadata) return
        readType(raw)?.let { meta.type = it }
        readTongueTargetId(raw)?.let { meta.tongueTargetId = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaFrogMetadata) return
        writeType(raw, meta.type)
        writeTongueTargetId(raw, meta.tongueTargetId)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaFrogMetadata::class.java
}
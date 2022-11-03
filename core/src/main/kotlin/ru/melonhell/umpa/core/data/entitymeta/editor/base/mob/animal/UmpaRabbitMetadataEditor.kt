package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAnimalMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaRabbitMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaRabbitMetadataEditor : UmpaAnimalMetadataEditor {

    fun readType(raw: UmpaRawEntityMetadata): UmpaRabbitMetadata.Type?
    fun writeType(raw: UmpaRawEntityMetadata, value: UmpaRabbitMetadata.Type?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaRabbitMetadata =
        UmpaRabbitMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaRabbitMetadata) return
        readType(raw)?.let { meta.type = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaRabbitMetadata) return
        writeType(raw, meta.type)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaRabbitMetadata::class.java
}
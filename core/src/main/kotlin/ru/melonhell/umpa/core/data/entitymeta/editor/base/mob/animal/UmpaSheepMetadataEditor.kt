package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAnimalMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaSheepMetadata
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaSheepMetadataEditor : UmpaAnimalMetadataEditor {

    fun readColor(raw: UmpaRawEntityMetadata): UmpaDyeColor?
    fun writeColor(raw: UmpaRawEntityMetadata, value: UmpaDyeColor?)

    fun readSheared(raw: UmpaRawEntityMetadata): Boolean?
    fun writeSheared(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSheepMetadata =
        UmpaSheepMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaSheepMetadata) return
        readColor(raw)?.let { meta.color = it }
        readSheared(raw)?.let { meta.sheared = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaSheepMetadata) return
        writeColor(raw, meta.color)
        writeSheared(raw, meta.sheared)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaSheepMetadata::class.java
}
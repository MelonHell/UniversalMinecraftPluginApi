package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaTamableAnimalMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaCatMetadata
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaCatMetadataEditor : UmpaTamableAnimalMetadataEditor {

    fun readType(raw: UmpaRawEntityMetadata): UmpaCatMetadata.Type?
    fun writeType(raw: UmpaRawEntityMetadata, value: UmpaCatMetadata.Type?)

    fun readLying(raw: UmpaRawEntityMetadata): Boolean?
    fun writeLying(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readRelaxed(raw: UmpaRawEntityMetadata): Boolean?
    fun writeRelaxed(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readCollarColor(raw: UmpaRawEntityMetadata): UmpaDyeColor?
    fun writeCollarColor(raw: UmpaRawEntityMetadata, value: UmpaDyeColor?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaCatMetadata = UmpaCatMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaCatMetadata) return
        readType(raw)?.let { meta.type = it }
        readLying(raw)?.let { meta.lying = it }
        readRelaxed(raw)?.let { meta.relaxed = it }
        readCollarColor(raw)?.let { meta.collarColor = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaCatMetadata) return
        writeType(raw, meta.type)
        writeLying(raw, meta.lying)
        writeRelaxed(raw, meta.relaxed)
        writeCollarColor(raw, meta.collarColor)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaCatMetadata::class.java
}
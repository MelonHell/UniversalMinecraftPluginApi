package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaCatMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaTamableAnimalMetadataEditor
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaCatMetadataEditor : UmpaTamableAnimalMetadataEditor {

    fun readType(raw: UmpaRawEntityMetadata): UmpaCatMetadata.Type?
    fun writeType(raw: UmpaRawEntityMetadata, value: UmpaCatMetadata.Type?)

    fun readIsLying(raw: UmpaRawEntityMetadata): Boolean?
    fun writeIsLying(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readRelaxStateOne(raw: UmpaRawEntityMetadata): Boolean?
    fun writeRelaxStateOne(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readCollarColor(raw: UmpaRawEntityMetadata): UmpaDyeColor?
    fun writeCollarColor(raw: UmpaRawEntityMetadata, value: UmpaDyeColor?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaCatMetadata = UmpaCatMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaCatMetadata) return
        readType(raw)?.let { meta.type = it }
        readIsLying(raw)?.let { meta.isLying = it }
        readRelaxStateOne(raw)?.let { meta.relaxStateOne = it }
        readCollarColor(raw)?.let { meta.collarColor = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaCatMetadata) return
        writeType(raw, meta.type)
        writeIsLying(raw, meta.isLying)
        writeRelaxStateOne(raw, meta.relaxStateOne)
        writeCollarColor(raw, meta.collarColor)
    }
}
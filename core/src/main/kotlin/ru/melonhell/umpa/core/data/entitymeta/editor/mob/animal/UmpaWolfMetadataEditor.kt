package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaWolfMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaTamableAnimalMetadataEditor
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaWolfMetadataEditor : UmpaTamableAnimalMetadataEditor {

    fun readInterested(raw: UmpaRawEntityMetadata): Boolean?
    fun writeInterested(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readCollarColor(raw: UmpaRawEntityMetadata): UmpaDyeColor?
    fun writeCollarColor(raw: UmpaRawEntityMetadata, value: UmpaDyeColor?)

    fun readRemainingAngerTime(raw: UmpaRawEntityMetadata): Int?
    fun writeRemainingAngerTime(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaWolfMetadata = UmpaWolfMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaWolfMetadata) return
        readInterested(raw)?.let { meta.interested = it }
        readCollarColor(raw)?.let { meta.collarColor = it }
        readRemainingAngerTime(raw)?.let { meta.remainingAngerTime = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaWolfMetadata) return
        writeInterested(raw, meta.interested)
        writeCollarColor(raw, meta.collarColor)
        writeRemainingAngerTime(raw, meta.remainingAngerTime)
    }
}
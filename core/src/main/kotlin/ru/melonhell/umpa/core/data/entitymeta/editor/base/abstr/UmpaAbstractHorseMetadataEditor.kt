package ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractHorseMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaAbstractHorseMetadataEditor : UmpaAnimalMetadataEditor {

    fun readTame(raw: UmpaRawEntityMetadata): Boolean?
    fun writeTame(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readSaddled(raw: UmpaRawEntityMetadata): Boolean?
    fun writeSaddled(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readHasBred(raw: UmpaRawEntityMetadata): Boolean?
    fun writeHasBred(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readEating(raw: UmpaRawEntityMetadata): Boolean?
    fun writeEating(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readRearing(raw: UmpaRawEntityMetadata): Boolean?
    fun writeRearing(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readMouthOpen(raw: UmpaRawEntityMetadata): Boolean?
    fun writeMouthOpen(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readOwnerUuid(raw: UmpaRawEntityMetadata): Optional<UUID>?
    fun writeOwnerUuid(raw: UmpaRawEntityMetadata, value: Optional<UUID>?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAbstractHorseMetadata =
        UmpaAbstractHorseMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaAbstractHorseMetadata) return
        readTame(raw)?.let { meta.tame = it }
        readSaddled(raw)?.let { meta.saddled = it }
        readHasBred(raw)?.let { meta.hasBred = it }
        readEating(raw)?.let { meta.eating = it }
        readRearing(raw)?.let { meta.rearing = it }
        readMouthOpen(raw)?.let { meta.mouthOpen = it }
        readOwnerUuid(raw)?.let { meta.ownerUuid = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaAbstractHorseMetadata) return
        writeTame(raw, meta.tame)
        writeSaddled(raw, meta.saddled)
        writeHasBred(raw, meta.hasBred)
        writeEating(raw, meta.eating)
        writeRearing(raw, meta.rearing)
        writeMouthOpen(raw, meta.mouthOpen)
        writeOwnerUuid(raw, meta.ownerUuid)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaAbstractHorseMetadata::class.java
}
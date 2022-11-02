package ru.melonhell.umpa.core.data.entitymeta.editor.test

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaFoxMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAnimalMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaFoxMetadataEditor : UmpaAnimalMetadataEditor {

    fun readType(raw: UmpaRawEntityMetadata): UmpaFoxMetadata.Type?
    fun writeType(raw: UmpaRawEntityMetadata, value: UmpaFoxMetadata.Type?)

    fun readSitting(raw: UmpaRawEntityMetadata): Boolean?
    fun writeSitting(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readFoxCrouching(raw: UmpaRawEntityMetadata): Boolean?
    fun writeFoxCrouching(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readInterested(raw: UmpaRawEntityMetadata): Boolean?
    fun writeInterested(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readPouncing(raw: UmpaRawEntityMetadata): Boolean?
    fun writePouncing(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readSleeping(raw: UmpaRawEntityMetadata): Boolean?
    fun writeSleeping(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readFaceplanted(raw: UmpaRawEntityMetadata): Boolean?
    fun writeFaceplanted(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readDefending(raw: UmpaRawEntityMetadata): Boolean?
    fun writeDefending(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readTrusted0(raw: UmpaRawEntityMetadata): Optional<UUID>?
    fun writeTrusted0(raw: UmpaRawEntityMetadata, value: Optional<UUID>?)

    fun readTrusted1(raw: UmpaRawEntityMetadata): Optional<UUID>?
    fun writeTrusted1(raw: UmpaRawEntityMetadata, value: Optional<UUID>?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaFoxMetadata = UmpaFoxMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaFoxMetadata) return
        readType(raw)?.let { meta.type = it }
        readSitting(raw)?.let { meta.sitting = it }
        readFoxCrouching(raw)?.let { meta.foxCrouching = it }
        readInterested(raw)?.let { meta.interested = it }
        readPouncing(raw)?.let { meta.pouncing = it }
        readSleeping(raw)?.let { meta.sleeping = it }
        readFaceplanted(raw)?.let { meta.faceplanted = it }
        readDefending(raw)?.let { meta.defending = it }
        readTrusted0(raw)?.let { meta.trusted0 = it }
        readTrusted1(raw)?.let { meta.trusted1 = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaFoxMetadata) return
        writeType(raw, meta.type)
        writeSitting(raw, meta.sitting)
        writeFoxCrouching(raw, meta.foxCrouching)
        writeInterested(raw, meta.interested)
        writePouncing(raw, meta.pouncing)
        writeSleeping(raw, meta.sleeping)
        writeFaceplanted(raw, meta.faceplanted)
        writeDefending(raw, meta.defending)
        writeTrusted0(raw, meta.trusted0)
        writeTrusted1(raw, meta.trusted1)
    }
}
package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaPandaMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAnimalMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaPandaMetadataEditor : UmpaAnimalMetadataEditor {

    fun readUnhappyCounter(raw: UmpaRawEntityMetadata): Int?
    fun writeUnhappyCounter(raw: UmpaRawEntityMetadata, value: Int?)

    fun readSneezeCounter(raw: UmpaRawEntityMetadata): Int?
    fun writeSneezeCounter(raw: UmpaRawEntityMetadata, value: Int?)

    fun readEatCounter(raw: UmpaRawEntityMetadata): Int?
    fun writeEatCounter(raw: UmpaRawEntityMetadata, value: Int?)

    fun readMainGene(raw: UmpaRawEntityMetadata): Int?
    fun writeMainGene(raw: UmpaRawEntityMetadata, value: Int?)

    fun readHiddenGene(raw: UmpaRawEntityMetadata): Int?
    fun writeHiddenGene(raw: UmpaRawEntityMetadata, value: Int?)

    fun readSneezing(raw: UmpaRawEntityMetadata): Boolean?
    fun writeSneezing(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readRolling(raw: UmpaRawEntityMetadata): Boolean?
    fun writeRolling(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readSitting(raw: UmpaRawEntityMetadata): Boolean?
    fun writeSitting(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readOnBack(raw: UmpaRawEntityMetadata): Boolean?
    fun writeOnBack(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaPandaMetadata =
        UmpaPandaMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaPandaMetadata) return
        readUnhappyCounter(raw)?.let { meta.unhappyCounter = it }
        readSneezeCounter(raw)?.let { meta.sneezeCounter = it }
        readEatCounter(raw)?.let { meta.eatCounter = it }
        readMainGene(raw)?.let { meta.mainGene = it }
        readHiddenGene(raw)?.let { meta.hiddenGene = it }
        readSneezing(raw)?.let { meta.sneezing = it }
        readRolling(raw)?.let { meta.rolling = it }
        readSitting(raw)?.let { meta.sitting = it }
        readOnBack(raw)?.let { meta.onBack = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaPandaMetadata) return
        writeUnhappyCounter(raw, meta.unhappyCounter)
        writeSneezeCounter(raw, meta.sneezeCounter)
        writeEatCounter(raw, meta.eatCounter)
        writeMainGene(raw, meta.mainGene)
        writeHiddenGene(raw, meta.hiddenGene)
        writeSneezing(raw, meta.sneezing)
        writeRolling(raw, meta.rolling)
        writeSitting(raw, meta.sitting)
        writeOnBack(raw, meta.onBack)
    }
}
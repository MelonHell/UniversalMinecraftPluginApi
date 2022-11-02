package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water.UmpaDolphinMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaWaterAnimalMetadataEditor
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaDolphinMetadataEditor : UmpaWaterAnimalMetadataEditor {

    fun readTreasurePos(raw: UmpaRawEntityMetadata): UmpaBlockPos?
    fun writeTreasurePos(raw: UmpaRawEntityMetadata, value: UmpaBlockPos?)

    fun readHasFish(raw: UmpaRawEntityMetadata): Boolean?
    fun writeHasFish(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readMoistnessLevel(raw: UmpaRawEntityMetadata): Int?
    fun writeMoistnessLevel(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaDolphinMetadata =
        UmpaDolphinMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaDolphinMetadata) return
        readTreasurePos(raw)?.let { meta.treasurePos = it }
        readHasFish(raw)?.let { meta.hasFish = it }
        readMoistnessLevel(raw)?.let { meta.moistnessLevel = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaDolphinMetadata) return
        writeTreasurePos(raw, meta.treasurePos)
        writeHasFish(raw, meta.hasFish)
        writeMoistnessLevel(raw, meta.moistnessLevel)
    }
}
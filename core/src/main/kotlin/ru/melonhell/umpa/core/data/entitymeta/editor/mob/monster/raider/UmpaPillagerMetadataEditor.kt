package ru.melonhell.umpa.core.data.entitymeta.editor.mob.monster.raider

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.raider.UmpaPillagerMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractIllagerMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaPillagerMetadataEditor : UmpaAbstractIllagerMetadataEditor {

    fun readChargingCrossbow(raw: UmpaRawEntityMetadata): Boolean?
    fun writeChargingCrossbow(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaPillagerMetadata =
        UmpaPillagerMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaPillagerMetadata) return
        readChargingCrossbow(raw)?.let { meta.chargingCrossbow = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaPillagerMetadata) return
        writeChargingCrossbow(raw, meta.chargingCrossbow)
    }
}
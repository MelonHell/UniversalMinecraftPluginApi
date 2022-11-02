package ru.melonhell.umpa.core.data.entitymeta.editor.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.UmpaVillagerMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractVillagerMetadataEditor
import ru.melonhell.umpa.core.utils.UmpaVillagerData
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaVillagerMetadataEditor : UmpaAbstractVillagerMetadataEditor {

    fun readVillagerData(raw: UmpaRawEntityMetadata): UmpaVillagerData?
    fun writeVillagerData(raw: UmpaRawEntityMetadata, value: UmpaVillagerData?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaVillagerMetadata =
        UmpaVillagerMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaVillagerMetadata) return
        readVillagerData(raw)?.let { meta.villagerData = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaVillagerMetadata) return
        writeVillagerData(raw, meta.villagerData)
    }
}
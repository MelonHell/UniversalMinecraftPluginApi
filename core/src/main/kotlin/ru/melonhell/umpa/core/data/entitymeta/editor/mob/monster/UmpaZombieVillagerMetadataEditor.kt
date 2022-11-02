package ru.melonhell.umpa.core.data.entitymeta.editor.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaZombieVillagerMetadata
import ru.melonhell.umpa.core.utils.UmpaVillagerData
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaZombieVillagerMetadataEditor : UmpaZombieMetadataEditor {

    fun readConverting(raw: UmpaRawEntityMetadata): Boolean?
    fun writeConverting(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readVillagerData(raw: UmpaRawEntityMetadata): UmpaVillagerData?
    fun writeVillagerData(raw: UmpaRawEntityMetadata, value: UmpaVillagerData?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaZombieVillagerMetadata =
        UmpaZombieVillagerMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaZombieVillagerMetadata) return
        readConverting(raw)?.let { meta.converting = it }
        readVillagerData(raw)?.let { meta.villagerData = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaZombieVillagerMetadata) return
        writeConverting(raw, meta.converting)
        writeVillagerData(raw, meta.villagerData)
    }
}
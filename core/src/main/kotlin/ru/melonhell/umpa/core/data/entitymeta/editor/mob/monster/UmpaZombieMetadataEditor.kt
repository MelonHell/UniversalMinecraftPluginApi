package ru.melonhell.umpa.core.data.entitymeta.editor.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaZombieMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaMonsterMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaZombieMetadataEditor : UmpaMonsterMetadataEditor {

    fun readBaby(raw: UmpaRawEntityMetadata): Boolean?
    fun writeBaby(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readSpecialType(raw: UmpaRawEntityMetadata): Int?
    fun writeSpecialType(raw: UmpaRawEntityMetadata, value: Int?)

    fun readDrownedConversion(raw: UmpaRawEntityMetadata): Boolean?
    fun writeDrownedConversion(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaZombieMetadata =
        UmpaZombieMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaZombieMetadata) return
        readBaby(raw)?.let { meta.baby = it }
        readSpecialType(raw)?.let { meta.specialType = it }
        readDrownedConversion(raw)?.let { meta.drownedConversion = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaZombieMetadata) return
        writeBaby(raw, meta.baby)
        writeSpecialType(raw, meta.specialType)
        writeDrownedConversion(raw, meta.drownedConversion)
    }
}
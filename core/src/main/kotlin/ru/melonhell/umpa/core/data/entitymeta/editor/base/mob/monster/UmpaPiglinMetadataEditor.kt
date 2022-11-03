package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractPiglinMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaPiglinMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaPiglinMetadataEditor : UmpaAbstractPiglinMetadataEditor {

    fun readBaby(raw: UmpaRawEntityMetadata): Boolean?
    fun writeBaby(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readChargingCrossbow(raw: UmpaRawEntityMetadata): Boolean?
    fun writeChargingCrossbow(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readDancing(raw: UmpaRawEntityMetadata): Boolean?
    fun writeDancing(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaPiglinMetadata =
        UmpaPiglinMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaPiglinMetadata) return
        readBaby(raw)?.let { meta.baby = it }
        readChargingCrossbow(raw)?.let { meta.chargingCrossbow = it }
        readDancing(raw)?.let { meta.dancing = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaPiglinMetadata) return
        writeBaby(raw, meta.baby)
        writeChargingCrossbow(raw, meta.chargingCrossbow)
        writeDancing(raw, meta.dancing)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaPiglinMetadata::class.java
}
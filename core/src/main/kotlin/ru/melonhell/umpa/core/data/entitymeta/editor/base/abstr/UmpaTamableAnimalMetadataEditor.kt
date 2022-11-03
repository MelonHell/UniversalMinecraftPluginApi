package ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaTamableAnimalMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaTamableAnimalMetadataEditor : UmpaAnimalMetadataEditor {

    fun readSitting(raw: UmpaRawEntityMetadata): Boolean?
    fun writeSitting(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readTamed(raw: UmpaRawEntityMetadata): Boolean?
    fun writeTamed(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readOwnerUuid(raw: UmpaRawEntityMetadata): Optional<UUID>?
    fun writeOwnerUuid(raw: UmpaRawEntityMetadata, value: Optional<UUID>?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaTamableAnimalMetadata =
        UmpaTamableAnimalMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaTamableAnimalMetadata) return
        readSitting(raw)?.let { meta.sitting = it }
        readTamed(raw)?.let { meta.tamed = it }
        readOwnerUuid(raw)?.let { meta.ownerUuid = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaTamableAnimalMetadata) return
        writeSitting(raw, meta.sitting)
        writeTamed(raw, meta.tamed)
        writeOwnerUuid(raw, meta.ownerUuid)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaTamableAnimalMetadata::class.java
}
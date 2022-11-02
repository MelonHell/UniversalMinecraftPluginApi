package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaHoglinMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAnimalMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaHoglinMetadataEditor : UmpaAnimalMetadataEditor {

    fun readImmuneToZombification(raw: UmpaRawEntityMetadata): Boolean?
    fun writeImmuneToZombification(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaHoglinMetadata =
        UmpaHoglinMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaHoglinMetadata) return
        readImmuneToZombification(raw)?.let { meta.immuneToZombification = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaHoglinMetadata) return
        writeImmuneToZombification(raw, meta.immuneToZombification)
    }
}
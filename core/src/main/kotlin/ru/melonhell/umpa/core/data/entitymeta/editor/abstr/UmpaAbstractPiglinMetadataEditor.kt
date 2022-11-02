package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractPiglinMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAbstractPiglinMetadataEditor : UmpaMonsterMetadataEditor {

    fun readImmuneToZombification(raw: UmpaRawEntityMetadata): Boolean?
    fun writeImmuneToZombification(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAbstractPiglinMetadata =
        UmpaAbstractPiglinMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaAbstractPiglinMetadata) return
        readImmuneToZombification(raw)?.let { meta.immuneToZombification = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaAbstractPiglinMetadata) return
        writeImmuneToZombification(raw, meta.immuneToZombification)
    }
}
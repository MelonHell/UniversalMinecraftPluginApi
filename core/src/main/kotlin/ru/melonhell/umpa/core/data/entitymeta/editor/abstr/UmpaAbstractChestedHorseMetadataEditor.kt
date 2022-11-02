package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractChestedHorseMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAbstractChestedHorseMetadataEditor : UmpaAbstractHorseMetadataEditor {

    fun readHasChest(raw: UmpaRawEntityMetadata): Boolean?
    fun writeHasChest(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAbstractChestedHorseMetadata =
        UmpaAbstractChestedHorseMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaAbstractChestedHorseMetadata) return
        readHasChest(raw)?.let { meta.hasChest = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaAbstractChestedHorseMetadata) return
        writeHasChest(raw, meta.hasChest)
    }
}
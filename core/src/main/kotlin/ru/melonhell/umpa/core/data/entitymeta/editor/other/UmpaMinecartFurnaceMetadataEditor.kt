package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaMinecartFurnaceMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractMinecartMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaMinecartFurnaceMetadataEditor : UmpaAbstractMinecartMetadataEditor {

    fun readFuel(raw: UmpaRawEntityMetadata): Boolean?
    fun writeFuel(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMinecartFurnaceMetadata =
        UmpaMinecartFurnaceMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaMinecartFurnaceMetadata) return
        readFuel(raw)?.let { meta.fuel = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaMinecartFurnaceMetadata) return
        writeFuel(raw, meta.fuel)
    }
}
package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractGolemMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.UmpaSnowGolemMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaSnowGolemMetadataEditor : UmpaAbstractGolemMetadataEditor {

    fun readPumpkin(raw: UmpaRawEntityMetadata): Boolean?
    fun writePumpkin(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSnowGolemMetadata =
        UmpaSnowGolemMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaSnowGolemMetadata) return
        readPumpkin(raw)?.let { meta.pumpkin = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaSnowGolemMetadata) return
        writePumpkin(raw, meta.pumpkin)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaSnowGolemMetadata::class.java
}
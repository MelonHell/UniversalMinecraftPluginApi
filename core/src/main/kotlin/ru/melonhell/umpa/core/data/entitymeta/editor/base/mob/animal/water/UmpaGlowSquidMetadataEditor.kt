package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water.UmpaGlowSquidMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaGlowSquidMetadataEditor : UmpaSquidMetadataEditor {

    fun readDarkTicksRemaining(raw: UmpaRawEntityMetadata): Int?
    fun writeDarkTicksRemaining(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaGlowSquidMetadata =
        UmpaGlowSquidMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaGlowSquidMetadata) return
        readDarkTicksRemaining(raw)?.let { meta.darkTicksRemaining = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaGlowSquidMetadata) return
        writeDarkTicksRemaining(raw, meta.darkTicksRemaining)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaGlowSquidMetadata::class.java
}
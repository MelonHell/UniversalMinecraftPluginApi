package ru.melonhell.umpa.core.data.entitymeta.editor.base.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaGlowItemFrameMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaGlowItemFrameMetadataEditor : UmpaItemFrameMetadataEditor {

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaGlowItemFrameMetadata =
        UmpaGlowItemFrameMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaGlowItemFrameMetadata) return
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaGlowItemFrameMetadata) return
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaGlowItemFrameMetadata::class.java
}
package ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr

import ru.melonhell.umpa.core.data.entitymeta.editor.base.UmpaEntityMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaHangingEntityMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaHangingEntityMetadataEditor : UmpaEntityMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaHangingEntityMetadata =
        UmpaHangingEntityMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaHangingEntityMetadata::class.java
}
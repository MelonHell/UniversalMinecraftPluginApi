package ru.melonhell.umpa.core.data.entitymeta.editor.base.other

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaHangingEntityMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaLeashKnotMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaLeashKnotMetadataEditor : UmpaHangingEntityMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaLeashKnotMetadata =
        UmpaLeashKnotMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaLeashKnotMetadata::class.java
}
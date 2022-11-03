package ru.melonhell.umpa.core.data.entitymeta.editor.base.projectile

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaFireballMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaLargeFireballMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaLargeFireballMetadataEditor : UmpaFireballMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaLargeFireballMetadata =
        UmpaLargeFireballMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaLargeFireballMetadata::class.java
}
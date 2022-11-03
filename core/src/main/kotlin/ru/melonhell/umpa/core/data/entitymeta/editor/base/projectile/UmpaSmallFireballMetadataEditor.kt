package ru.melonhell.umpa.core.data.entitymeta.editor.base.projectile

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaFireballMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaSmallFireballMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaSmallFireballMetadataEditor : UmpaFireballMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSmallFireballMetadata =
        UmpaSmallFireballMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaSmallFireballMetadata::class.java
}
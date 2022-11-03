package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.UmpaMagmaCubeMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaMagmaCubeMetadataEditor : UmpaSlimeMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMagmaCubeMetadata =
        UmpaMagmaCubeMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaMagmaCubeMetadata::class.java
}
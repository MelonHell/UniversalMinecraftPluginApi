package ru.melonhell.umpa.core.data.entitymeta.editor.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.UmpaMagmaCubeMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaMagmaCubeMetadataEditor : UmpaSlimeMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMagmaCubeMetadata =
        UmpaMagmaCubeMetadata().apply { readAll(raw, this) }
}
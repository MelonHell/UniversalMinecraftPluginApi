package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaExperienceOrbMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaExperienceOrbMetadataEditor : ru.melonhell.umpa.core.data.entitymeta.editor.UmpaEntityMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaExperienceOrbMetadata =
        UmpaExperienceOrbMetadata().apply { readAll(raw, this) }
}
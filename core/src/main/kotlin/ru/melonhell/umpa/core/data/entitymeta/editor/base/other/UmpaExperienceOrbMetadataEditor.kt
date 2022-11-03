package ru.melonhell.umpa.core.data.entitymeta.editor.base.other

import ru.melonhell.umpa.core.data.entitymeta.editor.base.UmpaEntityMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaExperienceOrbMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaExperienceOrbMetadataEditor : UmpaEntityMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaExperienceOrbMetadata =
        UmpaExperienceOrbMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaExperienceOrbMetadata::class.java
}
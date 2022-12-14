package ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaPathfinderMobMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaPathfinderMobMetadataEditor : UmpaMobMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaPathfinderMobMetadata =
        UmpaPathfinderMobMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaPathfinderMobMetadata::class.java
}
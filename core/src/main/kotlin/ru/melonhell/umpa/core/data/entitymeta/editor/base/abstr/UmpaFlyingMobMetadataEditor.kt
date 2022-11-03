package ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaFlyingMobMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaFlyingMobMetadataEditor : UmpaMobMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaFlyingMobMetadata =
        UmpaFlyingMobMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaFlyingMobMetadata::class.java
}
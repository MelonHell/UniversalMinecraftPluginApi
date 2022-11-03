package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractFishMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water.UmpaTadpoleMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaTadpoleMetadataEditor : UmpaAbstractFishMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaTadpoleMetadata =
        UmpaTadpoleMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaTadpoleMetadata::class.java
}
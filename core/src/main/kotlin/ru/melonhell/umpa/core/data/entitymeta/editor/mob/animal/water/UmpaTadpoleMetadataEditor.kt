package ru.melonhell.umpa.core.data.entitymeta.editor.test

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water.UmpaTadpoleMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractFishMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaTadpoleMetadataEditor : UmpaAbstractFishMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaTadpoleMetadata =
        UmpaTadpoleMetadata().apply { readAll(raw, this) }
}
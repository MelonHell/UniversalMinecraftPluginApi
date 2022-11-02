package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water.UmpaSalmonMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractSchoolingFishMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaSalmonMetadataEditor : UmpaAbstractSchoolingFishMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSalmonMetadata =
        UmpaSalmonMetadata().apply { readAll(raw, this) }
}
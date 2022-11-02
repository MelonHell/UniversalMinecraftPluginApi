package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water.UmpaSquidMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaWaterAnimalMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaSquidMetadataEditor : UmpaWaterAnimalMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSquidMetadata =
        UmpaSquidMetadata().apply { readAll(raw, this) }
}
package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaChickenMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAnimalMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaChickenMetadataEditor : UmpaAnimalMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaChickenMetadata =
        UmpaChickenMetadata().apply { readAll(raw, this) }
}
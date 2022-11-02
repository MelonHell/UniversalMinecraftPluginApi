package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaWaterAnimalMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaWaterAnimalMetadataEditor : UmpaPathfinderMobMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaWaterAnimalMetadata =
        UmpaWaterAnimalMetadata().apply { readAll(raw, this) }
}
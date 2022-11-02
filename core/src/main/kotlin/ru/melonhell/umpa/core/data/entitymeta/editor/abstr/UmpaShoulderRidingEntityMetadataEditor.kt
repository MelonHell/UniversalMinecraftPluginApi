package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaShoulderRidingEntityMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaShoulderRidingEntityMetadataEditor : UmpaTamableAnimalMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaShoulderRidingEntityMetadata =
        UmpaShoulderRidingEntityMetadata().apply { readAll(raw, this) }
}
package ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaShoulderRidingEntityMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaShoulderRidingEntityMetadataEditor : UmpaTamableAnimalMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaShoulderRidingEntityMetadata =
        UmpaShoulderRidingEntityMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaShoulderRidingEntityMetadata::class.java
}
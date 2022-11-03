package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaWaterAnimalMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water.UmpaSquidMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaSquidMetadataEditor : UmpaWaterAnimalMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSquidMetadata =
        UmpaSquidMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaSquidMetadata::class.java
}
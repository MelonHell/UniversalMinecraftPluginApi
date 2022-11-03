package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractSchoolingFishMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water.UmpaSalmonMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaSalmonMetadataEditor : UmpaAbstractSchoolingFishMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSalmonMetadata =
        UmpaSalmonMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaSalmonMetadata::class.java
}
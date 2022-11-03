package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractChestedHorseMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaDonkeyMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaDonkeyMetadataEditor : UmpaAbstractChestedHorseMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaDonkeyMetadata =
        UmpaDonkeyMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaDonkeyMetadata::class.java
}
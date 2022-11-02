package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaDonkeyMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractChestedHorseMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaDonkeyMetadataEditor : UmpaAbstractChestedHorseMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaDonkeyMetadata =
        UmpaDonkeyMetadata().apply { readAll(raw, this) }
}
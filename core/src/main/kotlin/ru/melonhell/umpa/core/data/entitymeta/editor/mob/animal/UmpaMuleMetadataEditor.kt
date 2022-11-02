package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaMuleMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractChestedHorseMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaMuleMetadataEditor : UmpaAbstractChestedHorseMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMuleMetadata = UmpaMuleMetadata().apply { readAll(raw, this) }
}
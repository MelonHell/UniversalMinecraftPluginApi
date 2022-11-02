package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal.water

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.water.UmpaCodMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractSchoolingFishMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaCodMetadataEditor : UmpaAbstractSchoolingFishMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaCodMetadata = UmpaCodMetadata().apply { readAll(raw, this) }
}
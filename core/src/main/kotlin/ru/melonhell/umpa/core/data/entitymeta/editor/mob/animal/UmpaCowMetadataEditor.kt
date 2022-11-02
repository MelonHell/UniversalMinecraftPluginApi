package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaCowMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAnimalMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaCowMetadataEditor : UmpaAnimalMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaCowMetadata = UmpaCowMetadata().apply { readAll(raw, this) }
}
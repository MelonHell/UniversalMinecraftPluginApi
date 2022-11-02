package ru.melonhell.umpa.core.data.entitymeta.editor.mob.monster.raider

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.raider.UmpaVindicatorMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractIllagerMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaVindicatorMetadataEditor : UmpaAbstractIllagerMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaVindicatorMetadata =
        UmpaVindicatorMetadata().apply { readAll(raw, this) }
}
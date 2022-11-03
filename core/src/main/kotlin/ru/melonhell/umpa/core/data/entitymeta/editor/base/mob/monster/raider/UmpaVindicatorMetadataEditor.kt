package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.raider

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractIllagerMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.raider.UmpaVindicatorMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaVindicatorMetadataEditor : UmpaAbstractIllagerMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaVindicatorMetadata =
        UmpaVindicatorMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaVindicatorMetadata::class.java
}
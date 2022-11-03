package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.raider

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaSpellcasterIllagerMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.raider.UmpaEvokerMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaEvokerMetadataEditor : UmpaSpellcasterIllagerMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaEvokerMetadata =
        UmpaEvokerMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaEvokerMetadata::class.java
}
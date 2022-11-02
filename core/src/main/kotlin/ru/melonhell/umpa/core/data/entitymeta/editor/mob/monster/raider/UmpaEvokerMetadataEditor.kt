package ru.melonhell.umpa.core.data.entitymeta.editor.mob.monster.raider

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.raider.UmpaEvokerMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaSpellcasterIllagerMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaEvokerMetadataEditor : UmpaSpellcasterIllagerMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaEvokerMetadata =
        UmpaEvokerMetadata().apply { readAll(raw, this) }
}
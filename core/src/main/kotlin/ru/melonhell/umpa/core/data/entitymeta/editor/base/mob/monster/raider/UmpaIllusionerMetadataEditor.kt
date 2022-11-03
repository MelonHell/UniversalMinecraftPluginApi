package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.raider

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaSpellcasterIllagerMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.raider.UmpaIllusionerMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaIllusionerMetadataEditor : UmpaSpellcasterIllagerMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaIllusionerMetadata =
        UmpaIllusionerMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaIllusionerMetadata::class.java
}
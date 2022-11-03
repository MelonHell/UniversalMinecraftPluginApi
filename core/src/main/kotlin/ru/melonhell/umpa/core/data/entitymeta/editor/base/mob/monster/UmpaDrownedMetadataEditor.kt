package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaDrownedMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaDrownedMetadataEditor : UmpaZombieMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaDrownedMetadata =
        UmpaDrownedMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaDrownedMetadata::class.java
}
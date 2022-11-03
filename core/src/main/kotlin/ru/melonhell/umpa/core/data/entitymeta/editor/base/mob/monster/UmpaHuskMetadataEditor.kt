package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaHuskMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaHuskMetadataEditor : UmpaZombieMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaHuskMetadata = UmpaHuskMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaHuskMetadata::class.java
}
package ru.melonhell.umpa.core.data.entitymeta.editor.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaHuskMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaHuskMetadataEditor : UmpaZombieMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaHuskMetadata = UmpaHuskMetadata().apply { readAll(raw, this) }
}
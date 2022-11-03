package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaZombifiedPiglinMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaZombifiedPiglinMetadataEditor : UmpaZombieMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaZombifiedPiglinMetadata =
        UmpaZombifiedPiglinMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaZombifiedPiglinMetadata::class.java
}
package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractHorseMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaZombieHorseMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaZombieHorseMetadataEditor : UmpaAbstractHorseMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaZombieHorseMetadata =
        UmpaZombieHorseMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaZombieHorseMetadata::class.java
}
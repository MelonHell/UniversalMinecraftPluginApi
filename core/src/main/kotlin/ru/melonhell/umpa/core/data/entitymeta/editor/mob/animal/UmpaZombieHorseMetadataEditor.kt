package ru.melonhell.umpa.core.data.entitymeta.editor.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaZombieHorseMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractHorseMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaZombieHorseMetadataEditor : UmpaAbstractHorseMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaZombieHorseMetadata =
        UmpaZombieHorseMetadata().apply { readAll(raw, this) }
}
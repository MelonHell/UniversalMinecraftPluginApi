package ru.melonhell.umpa.core.data.entitymeta.editor.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaEndermiteMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaMonsterMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaEndermiteMetadataEditor : UmpaMonsterMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaEndermiteMetadata =
        UmpaEndermiteMetadata().apply { readAll(raw, this) }
}
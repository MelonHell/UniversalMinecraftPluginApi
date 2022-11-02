package ru.melonhell.umpa.core.data.entitymeta.editor.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaPiglinBruteMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractPiglinMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaPiglinBruteMetadataEditor : UmpaAbstractPiglinMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaPiglinBruteMetadata =
        UmpaPiglinBruteMetadata().apply { readAll(raw, this) }
}
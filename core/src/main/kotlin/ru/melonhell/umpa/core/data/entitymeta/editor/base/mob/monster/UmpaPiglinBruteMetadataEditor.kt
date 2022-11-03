package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractPiglinMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaPiglinBruteMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaPiglinBruteMetadataEditor : UmpaAbstractPiglinMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaPiglinBruteMetadata =
        UmpaPiglinBruteMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaPiglinBruteMetadata::class.java
}
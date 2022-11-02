package ru.melonhell.umpa.core.data.entitymeta.editor.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaSilverfishMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaMonsterMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaSilverfishMetadataEditor : UmpaMonsterMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaSilverfishMetadata =
        UmpaSilverfishMetadata().apply { readAll(raw, this) }
}
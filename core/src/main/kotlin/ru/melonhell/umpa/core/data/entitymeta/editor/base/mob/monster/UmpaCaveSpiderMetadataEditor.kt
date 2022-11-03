package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaCaveSpiderMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaCaveSpiderMetadataEditor : UmpaSpiderMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaCaveSpiderMetadata =
        UmpaCaveSpiderMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaCaveSpiderMetadata::class.java
}
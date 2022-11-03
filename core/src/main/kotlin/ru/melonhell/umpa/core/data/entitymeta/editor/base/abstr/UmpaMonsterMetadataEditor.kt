package ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMonsterMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaMonsterMetadataEditor : UmpaPathfinderMobMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaMonsterMetadata =
        UmpaMonsterMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaMonsterMetadata::class.java
}
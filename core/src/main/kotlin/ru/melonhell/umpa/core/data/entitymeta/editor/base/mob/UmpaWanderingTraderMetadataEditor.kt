package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractVillagerMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.UmpaWanderingTraderMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaWanderingTraderMetadataEditor : UmpaAbstractVillagerMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaWanderingTraderMetadata =
        UmpaWanderingTraderMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaWanderingTraderMetadata::class.java
}
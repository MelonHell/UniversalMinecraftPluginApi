package ru.melonhell.umpa.core.data.entitymeta.editor.mob

import ru.melonhell.umpa.core.data.entitymeta.meta.mob.UmpaWanderingTraderMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaAbstractVillagerMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaWanderingTraderMetadataEditor : UmpaAbstractVillagerMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaWanderingTraderMetadata =
        UmpaWanderingTraderMetadata().apply { readAll(raw, this) }
}
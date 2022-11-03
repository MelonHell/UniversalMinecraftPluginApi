package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaElderGuardianMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaElderGuardianMetadataEditor : UmpaGuardianMetadataEditor {
    override fun readAll(raw: UmpaRawEntityMetadata): UmpaElderGuardianMetadata =
        UmpaElderGuardianMetadata().apply { readAll(raw, this) }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaElderGuardianMetadata::class.java
}
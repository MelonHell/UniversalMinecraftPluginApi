package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.monster

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.UmpaGuardianMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaMonsterMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaGuardianMetadataEditorImpl_v1_17_0 : UmpaGuardianMetadataEditor,
    UmpaMonsterMetadataEditorImpl_v1_17_0() {
    override fun readMoving(raw: UmpaRawEntityMetadata) = raw.readValue(16, Boolean::class.java)
    override fun writeMoving(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(16, value, Boolean::class.java)

    override fun readAttackTargetId(raw: UmpaRawEntityMetadata) = raw.readValue(17, Int::class.java)
    override fun writeAttackTargetId(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(17, value, Int::class.java)
}
package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.monster

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.UmpaWitherBossMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaMonsterMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaWitherBossMetadataEditorImpl_v1_17_0 : UmpaWitherBossMetadataEditor,
    UmpaMonsterMetadataEditorImpl_v1_17_0() {
    override fun readCenterHeadTargetId(raw: UmpaRawEntityMetadata) = raw.getValue(16, Int::class.java)
    override fun writeCenterHeadTargetId(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(16, value)

    override fun readLeftHeadTargetId(raw: UmpaRawEntityMetadata) = raw.getValue(17, Int::class.java)
    override fun writeLeftHeadTargetId(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(17, value)

    override fun readRightHeadTargetId(raw: UmpaRawEntityMetadata) = raw.getValue(18, Int::class.java)
    override fun writeRightHeadTargetId(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(18, value)

    override fun readInvulnerableTime(raw: UmpaRawEntityMetadata) = raw.getValue(19, Int::class.java)
    override fun writeInvulnerableTime(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(19, value)
}
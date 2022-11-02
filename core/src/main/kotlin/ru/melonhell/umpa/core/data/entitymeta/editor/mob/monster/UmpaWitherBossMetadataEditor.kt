package ru.melonhell.umpa.core.data.entitymeta.editor.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaWitherBossMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaMonsterMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaWitherBossMetadataEditor : UmpaMonsterMetadataEditor {

    fun readCenterHeadTargetId(raw: UmpaRawEntityMetadata): Int?
    fun writeCenterHeadTargetId(raw: UmpaRawEntityMetadata, value: Int?)

    fun readLeftHeadTargetId(raw: UmpaRawEntityMetadata): Int?
    fun writeLeftHeadTargetId(raw: UmpaRawEntityMetadata, value: Int?)

    fun readRightHeadTargetId(raw: UmpaRawEntityMetadata): Int?
    fun writeRightHeadTargetId(raw: UmpaRawEntityMetadata, value: Int?)

    fun readInvulnerableTime(raw: UmpaRawEntityMetadata): Int?
    fun writeInvulnerableTime(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaWitherBossMetadata =
        UmpaWitherBossMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaWitherBossMetadata) return
        readCenterHeadTargetId(raw)?.let { meta.centerHeadTargetId = it }
        readLeftHeadTargetId(raw)?.let { meta.leftHeadTargetId = it }
        readRightHeadTargetId(raw)?.let { meta.rightHeadTargetId = it }
        readInvulnerableTime(raw)?.let { meta.invulnerableTime = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaWitherBossMetadata) return
        writeCenterHeadTargetId(raw, meta.centerHeadTargetId)
        writeLeftHeadTargetId(raw, meta.leftHeadTargetId)
        writeRightHeadTargetId(raw, meta.rightHeadTargetId)
        writeInvulnerableTime(raw, meta.invulnerableTime)
    }
}
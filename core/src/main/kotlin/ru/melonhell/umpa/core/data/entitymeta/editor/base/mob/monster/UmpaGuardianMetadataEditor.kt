package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaMonsterMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.monster.UmpaGuardianMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaGuardianMetadataEditor : UmpaMonsterMetadataEditor {
    fun readMoving(raw: UmpaRawEntityMetadata): Boolean?
    fun writeMoving(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readAttackTargetId(raw: UmpaRawEntityMetadata): Int?
    fun writeAttackTargetId(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaGuardianMetadata =
        UmpaGuardianMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaGuardianMetadata) return
        readMoving(raw)?.let { meta.moving = it }
        readAttackTargetId(raw)?.let { meta.attackTargetId = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaGuardianMetadata) return
        writeMoving(raw, meta.moving)
        writeAttackTargetId(raw, meta.attackTargetId)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaGuardianMetadata::class.java
}
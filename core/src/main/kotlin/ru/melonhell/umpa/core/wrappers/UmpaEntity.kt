package ru.melonhell.umpa.core.wrappers

import ru.melonhell.umpa.core.data.entitymeta.UmpaEntityMetadata
import ru.melonhell.umpa.core.enums.keyed.UmpaEntityType
import java.util.*

abstract class UmpaEntity : UmpaWrapper() {
    abstract val entityId: Int
    abstract val uuid: UUID
    abstract val entityType: UmpaEntityType
    abstract fun readMeta(meta: UmpaEntityMetadata)
    abstract fun applyMeta(meta: UmpaEntityMetadata)
    abstract val rawMeta: UmpaRawEntityMetadata
}
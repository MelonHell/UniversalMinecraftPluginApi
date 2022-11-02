package ru.melonhell.umpa.core.data.entitymeta.editor.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaFishingBobberMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaProjectileMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaFishingBobberMetadataEditor : UmpaProjectileMetadataEditor {

    fun readHookedEntityId(raw: UmpaRawEntityMetadata): Int?
    fun writeHookedEntityId(raw: UmpaRawEntityMetadata, value: Int?)

    fun readBiting(raw: UmpaRawEntityMetadata): Boolean?
    fun writeBiting(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaFishingBobberMetadata =
        UmpaFishingBobberMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaFishingBobberMetadata) return
        readHookedEntityId(raw)?.let { meta.hookedEntityId = it }
        readBiting(raw)?.let { meta.biting = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaFishingBobberMetadata) return
        writeHookedEntityId(raw, meta.hookedEntityId)
        writeBiting(raw, meta.biting)
    }
}
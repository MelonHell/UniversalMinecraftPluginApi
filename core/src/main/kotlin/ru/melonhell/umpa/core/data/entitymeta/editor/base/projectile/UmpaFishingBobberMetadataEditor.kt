package ru.melonhell.umpa.core.data.entitymeta.editor.base.projectile

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaProjectileMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaFishingBobberMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaFishingBobberMetadataEditor : UmpaProjectileMetadataEditor {

    fun readHookedEntityId(raw: UmpaRawEntityMetadata): OptionalInt?
    fun writeHookedEntityId(raw: UmpaRawEntityMetadata, value: OptionalInt?)

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

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaFishingBobberMetadata::class.java
}
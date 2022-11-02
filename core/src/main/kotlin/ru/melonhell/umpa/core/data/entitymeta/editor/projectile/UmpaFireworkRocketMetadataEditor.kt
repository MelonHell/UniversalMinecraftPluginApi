package ru.melonhell.umpa.core.data.entitymeta.editor.projectile

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaFireworkRocketMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.test.abstr.UmpaProjectileMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaFireworkRocketMetadataEditor : UmpaProjectileMetadataEditor {

    fun readFireworksItem(raw: UmpaRawEntityMetadata): Optional<UmpaItemStack>?
    fun writeFireworksItem(raw: UmpaRawEntityMetadata, value: Optional<UmpaItemStack>?)

    fun readAttachedToTarget(raw: UmpaRawEntityMetadata): OptionalInt?
    fun writeAttachedToTarget(raw: UmpaRawEntityMetadata, value: OptionalInt?)

    fun readShotAtAngle(raw: UmpaRawEntityMetadata): Boolean?
    fun writeShotAtAngle(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaFireworkRocketMetadata =
        UmpaFireworkRocketMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaFireworkRocketMetadata) return
        readFireworksItem(raw)?.let { meta.fireworksItem = it }
        readAttachedToTarget(raw)?.let { meta.attachedToTarget = it }
        readShotAtAngle(raw)?.let { meta.shotAtAngle = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaFireworkRocketMetadata) return
        writeFireworksItem(raw, meta.fireworksItem)
        writeAttachedToTarget(raw, meta.attachedToTarget)
        writeShotAtAngle(raw, meta.shotAtAngle)
    }
}
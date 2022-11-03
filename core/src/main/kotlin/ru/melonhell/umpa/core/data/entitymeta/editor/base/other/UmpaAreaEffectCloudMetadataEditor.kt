package ru.melonhell.umpa.core.data.entitymeta.editor.base.other

import ru.melonhell.umpa.core.data.entitymeta.editor.base.UmpaEntityMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaAreaEffectCloudMetadata
import ru.melonhell.umpa.core.enums.keyed.UmpaParticleType
import ru.melonhell.umpa.core.utils.UmpaColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAreaEffectCloudMetadataEditor : UmpaEntityMetadataEditor {

    fun readRadius(raw: UmpaRawEntityMetadata): Float?
    fun writeRadius(raw: UmpaRawEntityMetadata, value: Float?)

    fun readColor(raw: UmpaRawEntityMetadata): UmpaColor?
    fun writeColor(raw: UmpaRawEntityMetadata, value: UmpaColor?)

    fun readWaiting(raw: UmpaRawEntityMetadata): Boolean?
    fun writeWaiting(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readParticle(raw: UmpaRawEntityMetadata): UmpaParticleType?
    fun writeParticle(raw: UmpaRawEntityMetadata, value: UmpaParticleType?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAreaEffectCloudMetadata =
        UmpaAreaEffectCloudMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaAreaEffectCloudMetadata) return
        readColor(raw)?.let { meta.color = it }
        readRadius(raw)?.let { meta.radius = it }
        readWaiting(raw)?.let { meta.waiting = it }
        readParticle(raw)?.let { meta.particle = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaAreaEffectCloudMetadata) return
        writeColor(raw, meta.color)
        writeRadius(raw, meta.radius)
        writeWaiting(raw, meta.waiting)
        writeParticle(raw, meta.particle)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaAreaEffectCloudMetadata::class.java
}
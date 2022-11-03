package ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractChestedHorseMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaLlamaMetadata
import ru.melonhell.umpa.core.enums.UmpaDyeColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaLlamaMetadataEditor : UmpaAbstractChestedHorseMetadataEditor {

    fun readStrength(raw: UmpaRawEntityMetadata): Int?
    fun writeStrength(raw: UmpaRawEntityMetadata, value: Int?)

    fun readCarpetColor(raw: UmpaRawEntityMetadata): Optional<UmpaDyeColor>?
    fun writeCarpetColor(raw: UmpaRawEntityMetadata, value: Optional<UmpaDyeColor>?)

    fun readType(raw: UmpaRawEntityMetadata): UmpaLlamaMetadata.Type?
    fun writeType(raw: UmpaRawEntityMetadata, value: UmpaLlamaMetadata.Type?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaLlamaMetadata =
        UmpaLlamaMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaLlamaMetadata) return
        readStrength(raw)?.let { meta.strength = it }
        readCarpetColor(raw)?.let { meta.carpetColor = it }
        readType(raw)?.let { meta.type = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaLlamaMetadata) return
        writeStrength(raw, meta.strength)
        writeCarpetColor(raw, meta.carpetColor)
        writeType(raw, meta.type)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaLlamaMetadata::class.java
}
package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaHorseMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractHorseMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaHorseMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaHorseMetadataEditorImpl_v1_17_0 : UmpaHorseMetadataEditor,
    UmpaAbstractHorseMetadataEditorImpl_v1_17_0() {
    private val colors = UmpaHorseMetadata.Color.values()
    private val markings = UmpaHorseMetadata.Marking.values()
    override fun readBaseColor(raw: UmpaRawEntityMetadata): UmpaHorseMetadata.Color? {
        return readIntColor(raw)?.let { colors[it] }
    }

    override fun writeBaseColor(raw: UmpaRawEntityMetadata, value: UmpaHorseMetadata.Color?) {
        if (value != null) writeColorAndMarking(raw, value.ordinal, readIntMarking(raw) ?: 0)
    }

    override fun readMarkings(raw: UmpaRawEntityMetadata): UmpaHorseMetadata.Marking? {
        return readIntMarking(raw)?.let { markings[it] }
    }

    override fun writeMarkings(raw: UmpaRawEntityMetadata, value: UmpaHorseMetadata.Marking?) {
        if (value != null) writeColorAndMarking(raw, readIntColor(raw) ?: 0, value.ordinal)
    }

    private fun readIntVariant(raw: UmpaRawEntityMetadata): Int? {
        return raw.readValue(19, Int::class.java)
    }

    private fun readIntColor(raw: UmpaRawEntityMetadata): Int? {
        return readIntVariant(raw)?.let { it and 255 }
    }

    private fun readIntMarking(raw: UmpaRawEntityMetadata): Int? {
        return readIntVariant(raw)?.let { (it and '\uff00'.code) shr 8 }
    }

    private fun writeColorAndMarking(raw: UmpaRawEntityMetadata, color: Int, marking: Int) {
        raw.writeValue(19, color and 255 or (marking shl 8 and '\uff00'.code), Int::class.java)
    }
}
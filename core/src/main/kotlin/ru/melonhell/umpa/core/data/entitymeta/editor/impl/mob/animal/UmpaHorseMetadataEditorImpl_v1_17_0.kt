package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaHorseMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractHorseMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaHorseMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaHorseMetadataEditorImpl_v1_17_0 : UmpaHorseMetadataEditor,
    UmpaAbstractHorseMetadataEditorImpl_v1_17_0() {
    override fun readBaseColor(raw: UmpaRawEntityMetadata) = null // = raw.getValue(1, Color::class.java)
    override fun writeBaseColor(raw: UmpaRawEntityMetadata, value: UmpaHorseMetadata.Color?) = Unit // = raw.setValue(1, value, Color::class.java)

    override fun readMarkings(raw: UmpaRawEntityMetadata) = null // = raw.getValue(1, Marking::class.java)
    override fun writeMarkings(raw: UmpaRawEntityMetadata, value: UmpaHorseMetadata.Marking?) = Unit // = raw.setValue(1, value, Marking::class.java)
}
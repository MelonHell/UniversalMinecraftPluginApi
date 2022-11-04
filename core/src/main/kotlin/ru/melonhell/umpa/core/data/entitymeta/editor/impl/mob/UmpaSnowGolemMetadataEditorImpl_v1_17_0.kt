package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.UmpaSnowGolemMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractGolemMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaSnowGolemMetadataEditorImpl_v1_17_0 : UmpaSnowGolemMetadataEditor,
    UmpaAbstractGolemMetadataEditorImpl_v1_17_0() {
    override fun readPumpkin(raw: UmpaRawEntityMetadata) =
        raw.readValue(16, Byte::class.java)?.let { it == 0x10.toByte() }

    override fun writePumpkin(raw: UmpaRawEntityMetadata, value: Boolean?) =
        raw.writeValue(16, value?.let { if (it) 0x10.toByte() else 0x00.toByte() }, Byte::class.java)
}
package ru.melonhell.umpa.core.data.entitymeta.editor.impl.other

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.other.UmpaEndCrystalMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.UmpaEntityMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.utils.UmpaBlockPos
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaEndCrystalMetadataEditorImpl_v1_17_0 : UmpaEndCrystalMetadataEditor,
    UmpaEntityMetadataEditorImpl_v1_17_0() {
    override fun readBeamTarget(raw: UmpaRawEntityMetadata) = raw.readOptional(8, UmpaBlockPos::class.java)
    override fun writeBeamTarget(raw: UmpaRawEntityMetadata, value: Optional<UmpaBlockPos>?) =
        raw.writeOptional(8, value, UmpaBlockPos::class.java)

    override fun readShowBottom(raw: UmpaRawEntityMetadata) = raw.readValue(9, Boolean::class.java)
    override fun writeShowBottom(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(9, value, Boolean::class.java)
}
package ru.melonhell.umpa.core.data.entitymeta.editor.impl.other

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.other.UmpaItemFrameMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaHangingEntityMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaItemFrameMetadataEditorImpl_v1_17_0 : UmpaItemFrameMetadataEditor,
    UmpaHangingEntityMetadataEditorImpl_v1_17_0() {
    override fun readItem(raw: UmpaRawEntityMetadata) = raw.readOptional(8, UmpaItemStack::class.java)
    override fun writeItem(raw: UmpaRawEntityMetadata, value: Optional<UmpaItemStack>?) =
        raw.writeOptional(8, value, UmpaItemStack::class.java)

    override fun readItemRotation(raw: UmpaRawEntityMetadata) = raw.readValue(9, Int::class.java)
    override fun writeItemRotation(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(9, value, Int::class.java)
}
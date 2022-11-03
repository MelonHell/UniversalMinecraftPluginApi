package ru.melonhell.umpa.core.data.entitymeta.editor.impl.other

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.other.UmpaItemEntityMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.UmpaEntityMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaItemEntityMetadataEditorImpl_v1_17_0 : UmpaItemEntityMetadataEditor,
    UmpaEntityMetadataEditorImpl_v1_17_0() {
    override fun readItem(raw: UmpaRawEntityMetadata) = raw.getOptional(8, UmpaItemStack::class.java)
    override fun writeItem(raw: UmpaRawEntityMetadata, value: Optional<UmpaItemStack>?) =
        raw.setOptional(8, value, UmpaItemStack::class.java)
}
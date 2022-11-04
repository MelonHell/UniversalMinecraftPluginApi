package ru.melonhell.umpa.core.data.entitymeta.editor.impl.other

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.other.UmpaEyeOfEnderMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.UmpaEntityMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaEyeOfEnderMetadataEditorImpl_v1_17_0 : UmpaEyeOfEnderMetadataEditor,
    UmpaEntityMetadataEditorImpl_v1_17_0() {
    override fun readItemStack(raw: UmpaRawEntityMetadata) = raw.readOptional(8, UmpaItemStack::class.java)
    override fun writeItemStack(raw: UmpaRawEntityMetadata, value: Optional<UmpaItemStack>?) =
        raw.writeOptional(8, value, UmpaItemStack::class.java)
}
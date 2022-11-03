package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaFireballMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaFireballMetadataEditorImpl_v1_17_0 : UmpaFireballMetadataEditor,
    UmpaAbstractHurtingProjectileMetadataEditorImpl_v1_17_0() {
    override fun readItemStack(raw: UmpaRawEntityMetadata) = raw.getOptional(8, UmpaItemStack::class.java)
    override fun writeItemStack(raw: UmpaRawEntityMetadata, value: Optional<UmpaItemStack>?) =
        raw.setOptional(8, value, UmpaItemStack::class.java)
}
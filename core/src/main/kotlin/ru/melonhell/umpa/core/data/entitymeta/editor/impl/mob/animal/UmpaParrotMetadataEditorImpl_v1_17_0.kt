package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaParrotMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaShoulderRidingEntityMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaParrotMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaParrotMetadataEditorImpl_v1_17_0 : UmpaParrotMetadataEditor,
    UmpaShoulderRidingEntityMetadataEditorImpl_v1_17_0() {
    private val types = UmpaParrotMetadata.Type.values()

    override fun readType(raw: UmpaRawEntityMetadata) = raw.getValue(1, Int::class.java)?.let { types[it] }
    override fun writeType(raw: UmpaRawEntityMetadata, value: UmpaParrotMetadata.Type?) =
        raw.setValue(1, value?.ordinal)
}
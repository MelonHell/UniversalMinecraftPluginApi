package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaMooshroomMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaMooshroomMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaMooshroomMetadataEditorImpl_v1_17_0 : UmpaMooshroomMetadataEditor, UmpaCowMetadataEditorImpl_v1_17_0() {
    override fun readType(raw: UmpaRawEntityMetadata) = raw.getValue(1, String::class.java)
        ?.let { if (it == "brown") UmpaMooshroomMetadata.Type.BROWN else UmpaMooshroomMetadata.Type.RED }

    override fun writeType(raw: UmpaRawEntityMetadata, value: UmpaMooshroomMetadata.Type?) =
        raw.setValue(1, value?.let { if (value == UmpaMooshroomMetadata.Type.BROWN) "brown" else "red" })
}
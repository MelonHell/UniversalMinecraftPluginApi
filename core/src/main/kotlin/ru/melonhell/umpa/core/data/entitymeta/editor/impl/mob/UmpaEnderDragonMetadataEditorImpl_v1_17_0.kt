package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.UmpaEnderDragonMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaMobMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.UmpaEnderDragonMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaEnderDragonMetadataEditorImpl_v1_17_0 : UmpaEnderDragonMetadataEditor,
    UmpaMobMetadataEditorImpl_v1_17_0() {
    private val phases = UmpaEnderDragonMetadata.Phase.values()

    override fun readPhase(raw: UmpaRawEntityMetadata) = raw.getValue(16, Int::class.java)?.let { phases[it] }
    override fun writePhase(raw: UmpaRawEntityMetadata, value: UmpaEnderDragonMetadata.Phase?) =
        raw.setValue(16, value?.ordinal)
}
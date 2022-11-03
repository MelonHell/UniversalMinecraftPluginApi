package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal.water

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.water.UmpaGlowSquidMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaGlowSquidMetadataEditorImpl_v1_17_0 : UmpaGlowSquidMetadataEditor,
    UmpaSquidMetadataEditorImpl_v1_17_0() {
    override fun readDarkTicksRemaining(raw: UmpaRawEntityMetadata) = raw.getValue(16, Int::class.java)
    override fun writeDarkTicksRemaining(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(16, value)
}
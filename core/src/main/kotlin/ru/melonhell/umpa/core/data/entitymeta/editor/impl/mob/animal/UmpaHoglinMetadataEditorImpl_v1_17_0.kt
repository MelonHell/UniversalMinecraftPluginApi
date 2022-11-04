package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaHoglinMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaHoglinMetadataEditorImpl_v1_17_0 : UmpaHoglinMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    override fun readImmuneToZombification(raw: UmpaRawEntityMetadata) = raw.readValue(17, Boolean::class.java)
    override fun writeImmuneToZombification(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(17, value, Boolean::class.java)
}
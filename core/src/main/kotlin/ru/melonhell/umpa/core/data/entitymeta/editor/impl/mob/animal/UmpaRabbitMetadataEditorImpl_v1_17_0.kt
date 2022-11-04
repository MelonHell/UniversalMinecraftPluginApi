package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaRabbitMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaRabbitMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaRabbitMetadataEditorImpl_v1_17_0 : UmpaRabbitMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    private val types = UmpaRabbitMetadata.Type.values()

    override fun readType(raw: UmpaRawEntityMetadata) = raw.readValue(17, Int::class.java)?.let { types[it] }
    override fun writeType(raw: UmpaRawEntityMetadata, value: UmpaRabbitMetadata.Type?) =
        raw.writeValue(17, value?.ordinal, Int::class.java)
}
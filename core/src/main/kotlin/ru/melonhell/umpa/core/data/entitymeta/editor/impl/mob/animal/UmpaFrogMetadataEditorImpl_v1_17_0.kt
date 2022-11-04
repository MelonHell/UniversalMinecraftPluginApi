package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaFrogMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaFrogMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaFrogMetadataEditorImpl_v1_17_0 : UmpaFrogMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    override fun readType(raw: UmpaRawEntityMetadata) = raw.readValue(17, UmpaFrogMetadata.Type::class.java)
    override fun writeType(raw: UmpaRawEntityMetadata, value: UmpaFrogMetadata.Type?) = raw.writeValue(17, value, UmpaFrogMetadata.Type::class.java)

    override fun readTongueTargetId(raw: UmpaRawEntityMetadata) = raw.readValue(18, OptionalInt::class.java)
    override fun writeTongueTargetId(raw: UmpaRawEntityMetadata, value: OptionalInt?) = raw.writeValue(18, value, OptionalInt::class.java)
}
package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaFrogMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaFrogMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaFrogMetadataEditorImpl_v1_17_0 : UmpaFrogMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    override fun readType(raw: UmpaRawEntityMetadata) = raw.getValue(17, UmpaFrogMetadata.Type::class.java)
    override fun writeType(raw: UmpaRawEntityMetadata, value: UmpaFrogMetadata.Type?) = raw.setValue(17, value)

    override fun readTongueTargetId(raw: UmpaRawEntityMetadata) = raw.getValue(18, OptionalInt::class.java)
    override fun writeTongueTargetId(raw: UmpaRawEntityMetadata, value: OptionalInt?) = raw.setValue(18, value)
}
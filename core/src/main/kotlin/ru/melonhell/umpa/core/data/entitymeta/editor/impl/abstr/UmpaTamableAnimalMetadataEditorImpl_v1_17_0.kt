package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaTamableAnimalMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaTamableAnimalMetadataEditorImpl_v1_17_0 : UmpaTamableAnimalMetadataEditor,
    UmpaAnimalMetadataEditorImpl_v1_17_0() {
    override fun readSitting(raw: UmpaRawEntityMetadata) = raw.getFlag(17, 0)
    override fun writeSitting(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(17, 0, value)

    override fun readTamed(raw: UmpaRawEntityMetadata) = raw.getFlag(17, 2)
    override fun writeTamed(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(17, 2, value)

    override fun readOwnerUuid(raw: UmpaRawEntityMetadata) = raw.getOptional(18, UUID::class.java)
    override fun writeOwnerUuid(raw: UmpaRawEntityMetadata, value: Optional<UUID>?) =
        raw.setOptional(18, value, UUID::class.java)
}
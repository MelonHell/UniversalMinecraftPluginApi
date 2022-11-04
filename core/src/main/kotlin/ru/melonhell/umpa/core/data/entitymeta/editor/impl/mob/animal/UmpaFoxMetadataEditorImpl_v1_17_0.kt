package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.animal

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.animal.UmpaFoxMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAnimalMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.animal.UmpaFoxMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaFoxMetadataEditorImpl_v1_17_0 : UmpaFoxMetadataEditor, UmpaAnimalMetadataEditorImpl_v1_17_0() {
    private val types = UmpaFoxMetadata.Type.values()

    override fun readType(raw: UmpaRawEntityMetadata) = raw.readValue(17, Int::class.java)?.let { types[it] }
    override fun writeType(raw: UmpaRawEntityMetadata, value: UmpaFoxMetadata.Type?) = raw.writeValue(17, value?.ordinal, Int::class.java)

    override fun readSitting(raw: UmpaRawEntityMetadata) = raw.readFlag(18, 0)
    override fun writeSitting(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(18, 0, value)

    override fun readFoxCrouching(raw: UmpaRawEntityMetadata) = raw.readFlag(18, 2)
    override fun writeFoxCrouching(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(18, 2, value)

    override fun readInterested(raw: UmpaRawEntityMetadata) = raw.readFlag(18, 3)
    override fun writeInterested(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(18, 3, value)

    override fun readPouncing(raw: UmpaRawEntityMetadata) = raw.readFlag(18, 4)
    override fun writePouncing(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(18, 4, value)

    override fun readSleeping(raw: UmpaRawEntityMetadata) = raw.readFlag(18, 5)
    override fun writeSleeping(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(18, 5, value)

    override fun readFaceplanted(raw: UmpaRawEntityMetadata) = raw.readFlag(18, 6)
    override fun writeFaceplanted(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(18, 6, value)

    override fun readDefending(raw: UmpaRawEntityMetadata) = raw.readFlag(18, 7)
    override fun writeDefending(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(18, 7, value)

    override fun readTrusted0(raw: UmpaRawEntityMetadata) = raw.readOptional(19, UUID::class.java)
    override fun writeTrusted0(raw: UmpaRawEntityMetadata, value: Optional<UUID>?) =
        raw.writeOptional(19, value, UUID::class.java)

    override fun readTrusted1(raw: UmpaRawEntityMetadata) = raw.readOptional(20, UUID::class.java)
    override fun writeTrusted1(raw: UmpaRawEntityMetadata, value: Optional<UUID>?) =
        raw.writeOptional(20, value, UUID::class.java)

}
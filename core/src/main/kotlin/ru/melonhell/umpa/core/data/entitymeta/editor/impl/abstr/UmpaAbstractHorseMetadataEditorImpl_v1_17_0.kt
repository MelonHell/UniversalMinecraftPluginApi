package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractHorseMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAbstractHorseMetadataEditorImpl_v1_17_0 : UmpaAbstractHorseMetadataEditor,
    UmpaAnimalMetadataEditorImpl_v1_17_0() {
    override fun readTame(raw: UmpaRawEntityMetadata) = raw.getFlag(17, 1)
    override fun writeTame(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(17, 1, value)

    override fun readSaddled(raw: UmpaRawEntityMetadata) = raw.getFlag(17, 2)
    override fun writeSaddled(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(17, 2, value)

    override fun readHasBred(raw: UmpaRawEntityMetadata) = raw.getFlag(17, 3)
    override fun writeHasBred(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(17, 3, value)

    override fun readEating(raw: UmpaRawEntityMetadata) = raw.getFlag(17, 4)
    override fun writeEating(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(17, 4, value)

    override fun readRearing(raw: UmpaRawEntityMetadata) = raw.getFlag(17, 5)
    override fun writeRearing(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(17, 5, value)

    override fun readMouthOpen(raw: UmpaRawEntityMetadata) = raw.getFlag(17, 6)
    override fun writeMouthOpen(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(17, 6, value)

    override fun readOwnerUuid(raw: UmpaRawEntityMetadata) = raw.getOptional(18, UUID::class.java)
    override fun writeOwnerUuid(raw: UmpaRawEntityMetadata, value: Optional<UUID>?) =
        raw.setOptional(18, value, UUID::class.java)
}
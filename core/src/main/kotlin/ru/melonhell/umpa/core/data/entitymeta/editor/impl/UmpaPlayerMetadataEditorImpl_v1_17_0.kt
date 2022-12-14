package ru.melonhell.umpa.core.data.entitymeta.editor.impl

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.UmpaPlayerMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaLivingEntityMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaNbt
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaPlayerMetadataEditorImpl_v1_17_0 : UmpaPlayerMetadataEditor,
    UmpaLivingEntityMetadataEditorImpl_v1_17_0() {

    override fun readPlayerAbsorption(raw: UmpaRawEntityMetadata) = raw.readValue(15, Float::class.java)
    override fun writePlayerAbsorption(raw: UmpaRawEntityMetadata, value: Float?) = raw.writeValue(15, value, Float::class.java)

    override fun readScore(raw: UmpaRawEntityMetadata) = raw.readValue(16, Int::class.java)
    override fun writeScore(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(16, value, Int::class.java)

    override fun readShowCape(raw: UmpaRawEntityMetadata) = raw.readFlag(17, 0)
    override fun writeShowCape(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(17, 0, value)

    override fun readShowJacket(raw: UmpaRawEntityMetadata) = raw.readFlag(17, 1)
    override fun writeShowJacket(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(17, 1, value)

    override fun readShowLeftSleeve(raw: UmpaRawEntityMetadata) = raw.readFlag(17, 2)
    override fun writeShowLeftSleeve(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(17, 2, value)

    override fun readShowRightSleeve(raw: UmpaRawEntityMetadata) = raw.readFlag(17, 3)
    override fun writeShowRightSleeve(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(17, 3, value)

    override fun readShowLeftPantsLeg(raw: UmpaRawEntityMetadata) = raw.readFlag(17, 4)
    override fun writeShowLeftPantsLeg(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(17, 4, value)

    override fun readShowRightPantsLeg(raw: UmpaRawEntityMetadata) = raw.readFlag(17, 5)
    override fun writeShowRightPantsLeg(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(17, 5, value)

    override fun readShowHat(raw: UmpaRawEntityMetadata) = raw.readFlag(17, 6)
    override fun writeShowHat(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(17, 6, value)

    override fun readLeftHanded(raw: UmpaRawEntityMetadata) =
        raw.readValue(18, Byte::class.java)?.let { it == 0.toByte() }

    override fun writeLeftHanded(raw: UmpaRawEntityMetadata, value: Boolean?) =
        raw.writeValue(18, value?.let { if (value) 0.toByte() else 1.toByte() }, Byte::class.java)

    override fun readShoulderLeft(raw: UmpaRawEntityMetadata) = raw.readValue(19, UmpaNbt::class.java)
    override fun writeShoulderLeft(raw: UmpaRawEntityMetadata, value: UmpaNbt?) = raw.writeValue(19, value, UmpaNbt::class.java)

    override fun readShoulderRight(raw: UmpaRawEntityMetadata) = raw.readValue(20, UmpaNbt::class.java)
    override fun writeShoulderRight(raw: UmpaRawEntityMetadata, value: UmpaNbt?) = raw.writeValue(20, value, UmpaNbt::class.java)
}
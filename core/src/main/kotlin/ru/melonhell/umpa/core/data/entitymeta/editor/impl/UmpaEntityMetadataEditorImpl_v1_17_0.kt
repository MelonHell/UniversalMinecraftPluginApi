package ru.melonhell.umpa.core.data.entitymeta.editor.impl

import net.kyori.adventure.text.Component
import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.UmpaEntityMetadataEditor
import ru.melonhell.umpa.core.enums.UmpaEntityPose
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaEntityMetadataEditorImpl_v1_17_0 : UmpaEntityMetadataEditor {
    override fun readOnFire(raw: UmpaRawEntityMetadata) = raw.getFlag(0, 0)
    override fun writeOnFire(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(0, 0, value)

    override fun readCrouching(raw: UmpaRawEntityMetadata) = raw.getFlag(0, 1)
    override fun writeCrouching(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(0, 1, value)

    override fun readRiding(raw: UmpaRawEntityMetadata) = raw.getFlag(0, 2)
    override fun writeRiding(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(0, 2, value)

    override fun readSprinting(raw: UmpaRawEntityMetadata) = raw.getFlag(0, 3)
    override fun writeSprinting(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(0, 3, value)

    override fun readSwimming(raw: UmpaRawEntityMetadata) = raw.getFlag(0, 4)
    override fun writeSwimming(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(0, 4, value)

    override fun readInvisible(raw: UmpaRawEntityMetadata) = raw.getFlag(0, 5)
    override fun writeInvisible(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(0, 5, value)

    override fun readGlowing(raw: UmpaRawEntityMetadata) = raw.getFlag(0, 6)
    override fun writeGlowing(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(0, 6, value)

    override fun readGliding(raw: UmpaRawEntityMetadata) = raw.getFlag(0, 7)
    override fun writeGliding(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(0, 7, value)

    override fun readAirTicks(raw: UmpaRawEntityMetadata) = raw.getValue(1, Int::class.java)
    override fun writeAirTicks(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(1, value)

    override fun readCustomName(raw: UmpaRawEntityMetadata) = raw.getOptional(2, Component::class.java)
    override fun writeCustomName(raw: UmpaRawEntityMetadata, value: Optional<Component>?) =
        raw.setOptional(2, value, Component::class.java)

    override fun readCustomNameVisible(raw: UmpaRawEntityMetadata) = raw.getValue(3, Boolean::class.java)
    override fun writeCustomNameVisible(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(3, value)

    override fun readSilent(raw: UmpaRawEntityMetadata) = raw.getValue(4, Boolean::class.java)
    override fun writeSilent(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(4, value)

    override fun readNoGravity(raw: UmpaRawEntityMetadata) = raw.getValue(5, Boolean::class.java)
    override fun writeNoGravity(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(5, value)

    override fun readEntityPose(raw: UmpaRawEntityMetadata) = raw.getValue(6, UmpaEntityPose::class.java)
    override fun writeEntityPose(raw: UmpaRawEntityMetadata, value: UmpaEntityPose?) = raw.setValue(6, value)

    override fun readFrozenTicks(raw: UmpaRawEntityMetadata) = raw.getValue(7, Int::class.java)
    override fun writeFrozenTicks(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(7, value)
}
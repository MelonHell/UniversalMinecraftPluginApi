package ru.melonhell.umpa.core.data.entitymeta.editor.impl

import net.kyori.adventure.text.Component
import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.UmpaEntityMetadataEditor
import ru.melonhell.umpa.core.enums.UmpaEntityPose
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaEntityMetadataEditorImpl_v1_17_0 : UmpaEntityMetadataEditor {
    override fun readOnFire(raw: UmpaRawEntityMetadata) = raw.readFlag(0, 0)
    override fun writeOnFire(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(0, 0, value)

    override fun readCrouching(raw: UmpaRawEntityMetadata) = raw.readFlag(0, 1)
    override fun writeCrouching(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(0, 1, value)

    override fun readRiding(raw: UmpaRawEntityMetadata) = raw.readFlag(0, 2)
    override fun writeRiding(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(0, 2, value)

    override fun readSprinting(raw: UmpaRawEntityMetadata) = raw.readFlag(0, 3)
    override fun writeSprinting(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(0, 3, value)

    override fun readSwimming(raw: UmpaRawEntityMetadata) = raw.readFlag(0, 4)
    override fun writeSwimming(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(0, 4, value)

    override fun readInvisible(raw: UmpaRawEntityMetadata) = raw.readFlag(0, 5)
    override fun writeInvisible(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(0, 5, value)

    override fun readGlowing(raw: UmpaRawEntityMetadata) = raw.readFlag(0, 6)
    override fun writeGlowing(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(0, 6, value)

    override fun readGliding(raw: UmpaRawEntityMetadata) = raw.readFlag(0, 7)
    override fun writeGliding(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeFlag(0, 7, value)

    override fun readAirTicks(raw: UmpaRawEntityMetadata) = raw.readValue(1, Int::class.java)
    override fun writeAirTicks(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(1, value, Int::class.java)

    override fun readCustomName(raw: UmpaRawEntityMetadata) = raw.readOptional(2, Component::class.java)
    override fun writeCustomName(raw: UmpaRawEntityMetadata, value: Optional<Component>?) =
        raw.writeOptional(2, value, Component::class.java)

    override fun readCustomNameVisible(raw: UmpaRawEntityMetadata) = raw.readValue(3, Boolean::class.java)
    override fun writeCustomNameVisible(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(3, value, Boolean::class.java)

    override fun readSilent(raw: UmpaRawEntityMetadata) = raw.readValue(4, Boolean::class.java)
    override fun writeSilent(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(4, value, Boolean::class.java)

    override fun readNoGravity(raw: UmpaRawEntityMetadata) = raw.readValue(5, Boolean::class.java)
    override fun writeNoGravity(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(5, value, Boolean::class.java)

    override fun readEntityPose(raw: UmpaRawEntityMetadata) = raw.readValue(6, UmpaEntityPose::class.java)
    override fun writeEntityPose(raw: UmpaRawEntityMetadata, value: UmpaEntityPose?) = raw.writeValue(6, value, UmpaEntityPose::class.java)

    override fun readFrozenTicks(raw: UmpaRawEntityMetadata) = raw.readValue(7, Int::class.java)
    override fun writeFrozenTicks(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(7, value, Int::class.java)
}
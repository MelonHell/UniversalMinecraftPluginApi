package ru.melonhell.umpa.core.data.entitymeta.editor.base

import net.kyori.adventure.text.Component
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.enums.UmpaEntityPose
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

interface UmpaEntityMetadataEditor {

    fun readOnFire(raw: UmpaRawEntityMetadata): Boolean?
    fun writeOnFire(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readCrouching(raw: UmpaRawEntityMetadata): Boolean?
    fun writeCrouching(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readRiding(raw: UmpaRawEntityMetadata): Boolean?
    fun writeRiding(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readSprinting(raw: UmpaRawEntityMetadata): Boolean?
    fun writeSprinting(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readSwimming(raw: UmpaRawEntityMetadata): Boolean?
    fun writeSwimming(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readInvisible(raw: UmpaRawEntityMetadata): Boolean?
    fun writeInvisible(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readGlowing(raw: UmpaRawEntityMetadata): Boolean?
    fun writeGlowing(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readGliding(raw: UmpaRawEntityMetadata): Boolean?
    fun writeGliding(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readAirTicks(raw: UmpaRawEntityMetadata): Int?
    fun writeAirTicks(raw: UmpaRawEntityMetadata, value: Int?)

    fun readCustomName(raw: UmpaRawEntityMetadata): Optional<Component>?
    fun writeCustomName(raw: UmpaRawEntityMetadata, value: Optional<Component>?)

    fun readCustomNameVisible(raw: UmpaRawEntityMetadata): Boolean?
    fun writeCustomNameVisible(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readSilent(raw: UmpaRawEntityMetadata): Boolean?
    fun writeSilent(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readNoGravity(raw: UmpaRawEntityMetadata): Boolean?
    fun writeNoGravity(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readEntityPose(raw: UmpaRawEntityMetadata): UmpaEntityPose?
    fun writeEntityPose(raw: UmpaRawEntityMetadata, value: UmpaEntityPose?)

    fun readFrozenTicks(raw: UmpaRawEntityMetadata): Int?
    fun writeFrozenTicks(raw: UmpaRawEntityMetadata, value: Int?)

    fun readAll(raw: UmpaRawEntityMetadata): UmpaEntityMetadata = UmpaEntityMetadata().apply { readAll(raw, this) }

    fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        readOnFire(raw)?.let { meta.onFire = it }
        readCrouching(raw)?.let { meta.crouching = it }
        readRiding(raw)?.let { meta.riding = it }
        readSprinting(raw)?.let { meta.sprinting = it }
        readSwimming(raw)?.let { meta.swimming = it }
        readInvisible(raw)?.let { meta.invisible = it }
        readGlowing(raw)?.let { meta.glowing = it }
        readGliding(raw)?.let { meta.gliding = it }
        readAirTicks(raw)?.let { meta.airTicks = it }
        readCustomName(raw)?.let { meta.customName = it }
        readCustomNameVisible(raw)?.let { meta.customNameVisible = it }
        readSilent(raw)?.let { meta.silent = it }
        readNoGravity(raw)?.let { meta.noGravity = it }
        readEntityPose(raw)?.let { meta.entityPose = it }
        readFrozenTicks(raw)?.let { meta.frozenTicks = it }
    }

    fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        writeOnFire(raw, meta.onFire)
        writeCrouching(raw, meta.crouching)
        writeRiding(raw, meta.riding)
        writeSprinting(raw, meta.sprinting)
        writeSwimming(raw, meta.swimming)
        writeInvisible(raw, meta.invisible)
        writeGlowing(raw, meta.glowing)
        writeGliding(raw, meta.gliding)
        writeAirTicks(raw, meta.airTicks)
        writeCustomName(raw, meta.customName)
        writeCustomNameVisible(raw, meta.customNameVisible)
        writeSilent(raw, meta.silent)
        writeNoGravity(raw, meta.noGravity)
        writeEntityPose(raw, meta.entityPose)
        writeFrozenTicks(raw, meta.frozenTicks)
    }

    val metaType get(): Class<out UmpaEntityMetadata> = UmpaEntityMetadata::class.java
}
package ru.melonhell.umpa.core.data.entitymeta.editor.abstr

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaAbstractMinecartMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaAbstractMinecartMetadataEditor : ru.melonhell.umpa.core.data.entitymeta.editor.UmpaEntityMetadataEditor {

    fun readHurt(raw: UmpaRawEntityMetadata): Int?
    fun writeHurt(raw: UmpaRawEntityMetadata, value: Int?)

    fun readHurtdir(raw: UmpaRawEntityMetadata): Int?
    fun writeHurtdir(raw: UmpaRawEntityMetadata, value: Int?)

    fun readDamage(raw: UmpaRawEntityMetadata): Float?
    fun writeDamage(raw: UmpaRawEntityMetadata, value: Float?)

    fun readDisplayBlock(raw: UmpaRawEntityMetadata): Int?
    fun writeDisplayBlock(raw: UmpaRawEntityMetadata, value: Int?)

    fun readDisplayOffset(raw: UmpaRawEntityMetadata): Int?
    fun writeDisplayOffset(raw: UmpaRawEntityMetadata, value: Int?)

    fun readCustomDisplay(raw: UmpaRawEntityMetadata): Boolean?
    fun writeCustomDisplay(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaAbstractMinecartMetadata =
        UmpaAbstractMinecartMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaAbstractMinecartMetadata) return
        readHurt(raw)?.let { meta.hurt = it }
        readHurtdir(raw)?.let { meta.hurtdir = it }
        readDamage(raw)?.let { meta.damage = it }
        readDisplayBlock(raw)?.let { meta.displayBlock = it }
        readDisplayOffset(raw)?.let { meta.displayOffset = it }
        readCustomDisplay(raw)?.let { meta.customDisplay = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaAbstractMinecartMetadata) return
        writeHurt(raw, meta.hurt)
        writeHurtdir(raw, meta.hurtdir)
        writeDamage(raw, meta.damage)
        writeDisplayBlock(raw, meta.displayBlock)
        writeDisplayOffset(raw, meta.displayOffset)
        writeCustomDisplay(raw, meta.customDisplay)
    }
}
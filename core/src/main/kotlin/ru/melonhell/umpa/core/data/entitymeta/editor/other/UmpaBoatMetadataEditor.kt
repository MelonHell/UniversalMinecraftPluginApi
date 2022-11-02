package ru.melonhell.umpa.core.data.entitymeta.editor.other

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaBoatMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaBoatMetadataEditor : ru.melonhell.umpa.core.data.entitymeta.editor.UmpaEntityMetadataEditor {

    fun readHurt(raw: UmpaRawEntityMetadata): Int?
    fun writeHurt(raw: UmpaRawEntityMetadata, value: Int?)

    fun readHurtdir(raw: UmpaRawEntityMetadata): Int?
    fun writeHurtdir(raw: UmpaRawEntityMetadata, value: Int?)

    fun readDamage(raw: UmpaRawEntityMetadata): Float?
    fun writeDamage(raw: UmpaRawEntityMetadata, value: Float?)

    fun readType(raw: UmpaRawEntityMetadata): UmpaBoatMetadata.Type?
    fun writeType(raw: UmpaRawEntityMetadata, value: UmpaBoatMetadata.Type?)

    fun readPaddleLeft(raw: UmpaRawEntityMetadata): Boolean?
    fun writePaddleLeft(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readPaddleRight(raw: UmpaRawEntityMetadata): Boolean?
    fun writePaddleRight(raw: UmpaRawEntityMetadata, value: Boolean?)

    fun readBubbleTime(raw: UmpaRawEntityMetadata): Int?
    fun writeBubbleTime(raw: UmpaRawEntityMetadata, value: Int?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaBoatMetadata = UmpaBoatMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaBoatMetadata) return
        readHurt(raw)?.let { meta.hurt = it }
        readHurtdir(raw)?.let { meta.hurtdir = it }
        readDamage(raw)?.let { meta.damage = it }
        readType(raw)?.let { meta.type = it }
        readPaddleLeft(raw)?.let { meta.paddleLeft = it }
        readPaddleRight(raw)?.let { meta.paddleRight = it }
        readBubbleTime(raw)?.let { meta.bubbleTime = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaBoatMetadata) return
        writeHurt(raw, meta.hurt)
        writeHurtdir(raw, meta.hurtdir)
        writeDamage(raw, meta.damage)
        writeType(raw, meta.type)
        writePaddleLeft(raw, meta.paddleLeft)
        writePaddleRight(raw, meta.paddleRight)
        writeBubbleTime(raw, meta.bubbleTime)
    }
}
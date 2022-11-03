package ru.melonhell.umpa.core.data.entitymeta.editor.base.projectile

import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractArrowMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.projectile.UmpaThrownTridentMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaThrownTridentMetadataEditor : UmpaAbstractArrowMetadataEditor {

    fun readLoyaltyLevel(raw: UmpaRawEntityMetadata): Int?
    fun writeLoyaltyLevel(raw: UmpaRawEntityMetadata, value: Int?)

    fun readHasEnchantmentGlint(raw: UmpaRawEntityMetadata): Boolean?
    fun writeHasEnchantmentGlint(raw: UmpaRawEntityMetadata, value: Boolean?)

    override fun readAll(raw: UmpaRawEntityMetadata): UmpaThrownTridentMetadata =
        UmpaThrownTridentMetadata().apply { readAll(raw, this) }

    override fun readAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.readAll(raw, meta)
        if (meta !is UmpaThrownTridentMetadata) return
        readLoyaltyLevel(raw)?.let { meta.loyaltyLevel = it }
        readHasEnchantmentGlint(raw)?.let { meta.hasEnchantmentGlint = it }
    }

    override fun writeAll(raw: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        super.writeAll(raw, meta)
        if (meta !is UmpaThrownTridentMetadata) return
        writeLoyaltyLevel(raw, meta.loyaltyLevel)
        writeHasEnchantmentGlint(raw, meta.hasEnchantmentGlint)
    }

    override val metaType get(): Class<out UmpaEntityMetadata> = UmpaThrownTridentMetadata::class.java
}
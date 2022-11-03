package ru.melonhell.umpa.core.data.entitymeta.editor.impl.projectile

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.projectile.UmpaThrownTridentMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractArrowMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaThrownTridentMetadataEditorImpl_v1_17_0 : UmpaThrownTridentMetadataEditor,
    UmpaAbstractArrowMetadataEditorImpl_v1_17_0() {
    override fun readLoyaltyLevel(raw: UmpaRawEntityMetadata) = raw.getValue(10, Int::class.java)
    override fun writeLoyaltyLevel(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(10, value)

    override fun readHasEnchantmentGlint(raw: UmpaRawEntityMetadata) = raw.getValue(11, Boolean::class.java)
    override fun writeHasEnchantmentGlint(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(11, value)
}
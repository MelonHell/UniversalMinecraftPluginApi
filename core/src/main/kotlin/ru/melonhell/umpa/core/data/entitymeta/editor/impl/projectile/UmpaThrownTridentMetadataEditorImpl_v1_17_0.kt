package ru.melonhell.umpa.core.data.entitymeta.editor.impl.projectile

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.projectile.UmpaThrownTridentMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractArrowMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaThrownTridentMetadataEditorImpl_v1_17_0 : UmpaThrownTridentMetadataEditor,
    UmpaAbstractArrowMetadataEditorImpl_v1_17_0() {
    override fun readLoyaltyLevel(raw: UmpaRawEntityMetadata) = raw.readValue(10, Int::class.java)
    override fun writeLoyaltyLevel(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(10, value, Int::class.java)

    override fun readHasEnchantmentGlint(raw: UmpaRawEntityMetadata) = raw.readValue(11, Boolean::class.java)
    override fun writeHasEnchantmentGlint(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(11, value, Boolean::class.java)
}
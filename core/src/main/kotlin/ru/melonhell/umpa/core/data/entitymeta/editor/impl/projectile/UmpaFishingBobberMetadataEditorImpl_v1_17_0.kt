package ru.melonhell.umpa.core.data.entitymeta.editor.impl.projectile

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.projectile.UmpaFishingBobberMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaProjectileMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaFishingBobberMetadataEditorImpl_v1_17_0 : UmpaFishingBobberMetadataEditor,
    UmpaProjectileMetadataEditorImpl_v1_17_0() {
    override fun readHookedEntityId(raw: UmpaRawEntityMetadata): OptionalInt? {
        val value = raw.readValue(8, Int::class.java) ?: return  null
        return if (value == 0) OptionalInt.empty() else OptionalInt.of(value - 1)
    }
    override fun writeHookedEntityId(raw: UmpaRawEntityMetadata, value: OptionalInt?) {
        raw.writeValue(8, value?.orElse(-1)?.let { it + 1 }, Int::class.java)
    }

    override fun readBiting(raw: UmpaRawEntityMetadata) = raw.readValue(9, Boolean::class.java)
    override fun writeBiting(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(9, value, Boolean::class.java)
}
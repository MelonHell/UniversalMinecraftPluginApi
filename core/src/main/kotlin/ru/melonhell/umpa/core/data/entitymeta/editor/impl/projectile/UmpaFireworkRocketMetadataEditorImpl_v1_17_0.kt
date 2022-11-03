package ru.melonhell.umpa.core.data.entitymeta.editor.impl.projectile

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.projectile.UmpaFireworkRocketMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaProjectileMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaItemStack
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaFireworkRocketMetadataEditorImpl_v1_17_0 : UmpaFireworkRocketMetadataEditor,
    UmpaProjectileMetadataEditorImpl_v1_17_0() {
    override fun readFireworksItem(raw: UmpaRawEntityMetadata) = raw.getOptional(8, UmpaItemStack::class.java)
    override fun writeFireworksItem(raw: UmpaRawEntityMetadata, value: Optional<UmpaItemStack>?) =
        raw.setOptional(8, value, UmpaItemStack::class.java)

    override fun readAttachedToTarget(raw: UmpaRawEntityMetadata) = raw.getValue(9, OptionalInt::class.java)
    override fun writeAttachedToTarget(raw: UmpaRawEntityMetadata, value: OptionalInt?) = raw.setValue(9, value)

    override fun readShotAtAngle(raw: UmpaRawEntityMetadata) = raw.getValue(10, Boolean::class.java)
    override fun writeShotAtAngle(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(10, value)
}
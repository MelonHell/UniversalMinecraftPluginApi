package ru.melonhell.umpa.core.data.entitymeta.editor.impl.projectile

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.projectile.UmpaWitherSkullMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractHurtingProjectileMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaWitherSkullMetadataEditorImpl_v1_17_0 : UmpaWitherSkullMetadataEditor,
    UmpaAbstractHurtingProjectileMetadataEditorImpl_v1_17_0() {
    override fun readInvulnerable(raw: UmpaRawEntityMetadata) = raw.getValue(8, Boolean::class.java)
    override fun writeInvulnerable(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setValue(8, value)
}
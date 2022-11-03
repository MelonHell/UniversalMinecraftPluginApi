package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractHurtingProjectileMetadataEditor

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAbstractHurtingProjectileMetadataEditorImpl_v1_17_0 : UmpaAbstractHurtingProjectileMetadataEditor,
    UmpaProjectileMetadataEditorImpl_v1_17_0()
package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaFlyingMobMetadataEditor

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaFlyingMobMetadataEditorImpl_v1_17_0 : UmpaFlyingMobMetadataEditor, UmpaMobMetadataEditorImpl_v1_17_0()
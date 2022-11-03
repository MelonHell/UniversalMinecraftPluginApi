package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaPathfinderMobMetadataEditor

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaPathfinderMobMetadataEditorImpl_v1_17_0 : UmpaPathfinderMobMetadataEditor,
    UmpaMobMetadataEditorImpl_v1_17_0()
package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAmbientCreatureMetadataEditor

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAmbientCreatureMetadataEditorImpl_v1_17_0 : UmpaAmbientCreatureMetadataEditor,
    UmpaMobMetadataEditorImpl_v1_17_0()
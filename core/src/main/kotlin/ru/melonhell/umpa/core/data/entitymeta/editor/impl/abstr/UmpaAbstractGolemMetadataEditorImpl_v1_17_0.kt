package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractGolemMetadataEditor

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAbstractGolemMetadataEditorImpl_v1_17_0 : UmpaAbstractGolemMetadataEditor,
    UmpaPathfinderMobMetadataEditorImpl_v1_17_0()
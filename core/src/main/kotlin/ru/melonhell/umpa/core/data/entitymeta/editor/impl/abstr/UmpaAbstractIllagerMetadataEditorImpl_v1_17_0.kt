package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractIllagerMetadataEditor

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAbstractIllagerMetadataEditorImpl_v1_17_0 : UmpaAbstractIllagerMetadataEditor,
    UmpaRaiderMetadataEditorImpl_v1_17_0()
package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaProjectileMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.UmpaEntityMetadataEditorImpl_v1_17_0

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaProjectileMetadataEditorImpl_v1_17_0 : UmpaProjectileMetadataEditor,
    UmpaEntityMetadataEditorImpl_v1_17_0()
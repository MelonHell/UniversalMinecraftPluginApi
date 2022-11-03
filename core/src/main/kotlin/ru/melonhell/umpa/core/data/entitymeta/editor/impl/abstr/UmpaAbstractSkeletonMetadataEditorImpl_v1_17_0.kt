package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractSkeletonMetadataEditor

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAbstractSkeletonMetadataEditorImpl_v1_17_0 : UmpaAbstractSkeletonMetadataEditor,
    UmpaMonsterMetadataEditorImpl_v1_17_0()
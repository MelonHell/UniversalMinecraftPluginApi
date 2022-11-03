package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaPatrollingMonsterMetadataEditor

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaPatrollingMonsterMetadataEditorImpl_v1_17_0 : UmpaPatrollingMonsterMetadataEditor,
    UmpaMonsterMetadataEditorImpl_v1_17_0()
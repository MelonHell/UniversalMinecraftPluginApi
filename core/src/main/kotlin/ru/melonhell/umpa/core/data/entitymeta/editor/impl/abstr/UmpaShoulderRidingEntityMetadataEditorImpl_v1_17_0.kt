package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaShoulderRidingEntityMetadataEditor

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaShoulderRidingEntityMetadataEditorImpl_v1_17_0 : UmpaShoulderRidingEntityMetadataEditor,
    UmpaTamableAnimalMetadataEditorImpl_v1_17_0()
package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaWaterAnimalMetadataEditor

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaWaterAnimalMetadataEditorImpl_v1_17_0 : UmpaWaterAnimalMetadataEditor,
    UmpaPathfinderMobMetadataEditorImpl_v1_17_0()
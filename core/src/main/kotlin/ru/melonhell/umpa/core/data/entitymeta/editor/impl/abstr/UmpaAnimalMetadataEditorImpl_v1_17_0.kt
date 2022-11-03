package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAnimalMetadataEditor

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAnimalMetadataEditorImpl_v1_17_0 : UmpaAnimalMetadataEditor, UmpaAgeableMobMetadataEditorImpl_v1_17_0()
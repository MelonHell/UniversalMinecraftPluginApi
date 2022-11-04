package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.monster

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.UmpaZombieVillagerMetadataEditor
import ru.melonhell.umpa.core.utils.UmpaVillagerData
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaZombieVillagerMetadataEditorImpl_v1_17_0 : UmpaZombieVillagerMetadataEditor,
    UmpaZombieMetadataEditorImpl_v1_17_0() {

    override fun readConverting(raw: UmpaRawEntityMetadata) = raw.readValue(19, Boolean::class.java)
    override fun writeConverting(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(19, value, Boolean::class.java)

    override fun readVillagerData(raw: UmpaRawEntityMetadata) = raw.readValue(20, UmpaVillagerData::class.java)
    override fun writeVillagerData(raw: UmpaRawEntityMetadata, value: UmpaVillagerData?) = raw.writeValue(20, value, UmpaVillagerData::class.java)

}
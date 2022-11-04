package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.monster

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.UmpaZombieMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaMonsterMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaZombieMetadataEditorImpl_v1_17_0 : UmpaZombieMetadataEditor, UmpaMonsterMetadataEditorImpl_v1_17_0() {
    override fun readBaby(raw: UmpaRawEntityMetadata) = raw.readValue(16, Boolean::class.java)
    override fun writeBaby(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(16, value, Boolean::class.java)

    override fun readSpecialType(raw: UmpaRawEntityMetadata) = raw.readValue(17, Int::class.java)
    override fun writeSpecialType(raw: UmpaRawEntityMetadata, value: Int?) = raw.writeValue(17, value, Int::class.java)

    override fun readDrownedConversion(raw: UmpaRawEntityMetadata) = raw.readValue(18, Boolean::class.java)
    override fun writeDrownedConversion(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(18, value, Boolean::class.java)
}
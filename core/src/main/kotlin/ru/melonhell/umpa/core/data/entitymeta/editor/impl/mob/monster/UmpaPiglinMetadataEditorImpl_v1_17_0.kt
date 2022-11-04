package ru.melonhell.umpa.core.data.entitymeta.editor.impl.mob.monster

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.mob.monster.UmpaPiglinMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractPiglinMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaPiglinMetadataEditorImpl_v1_17_0 : UmpaPiglinMetadataEditor,
    UmpaAbstractPiglinMetadataEditorImpl_v1_17_0() {
    override fun readBaby(raw: UmpaRawEntityMetadata) = raw.readValue(17, Boolean::class.java)
    override fun writeBaby(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(17, value, Boolean::class.java)

    override fun readChargingCrossbow(raw: UmpaRawEntityMetadata) = raw.readValue(18, Boolean::class.java)
    override fun writeChargingCrossbow(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(18, value, Boolean::class.java)

    override fun readDancing(raw: UmpaRawEntityMetadata) = raw.readValue(19, Boolean::class.java)
    override fun writeDancing(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.writeValue(19, value, Boolean::class.java)
}
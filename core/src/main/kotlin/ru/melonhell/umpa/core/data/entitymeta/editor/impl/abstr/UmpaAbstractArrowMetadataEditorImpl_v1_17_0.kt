package ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.abstr.UmpaAbstractArrowMetadataEditor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaAbstractArrowMetadataEditorImpl_v1_17_0 : UmpaAbstractArrowMetadataEditor,
    UmpaProjectileMetadataEditorImpl_v1_17_0() {

    override fun readCritical(raw: UmpaRawEntityMetadata) = raw.getFlag(8, 0)
    override fun writeCritical(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(8, 0, value)

    override fun readNoclip(raw: UmpaRawEntityMetadata) = raw.getFlag(8, 1)
    override fun writeNoclip(raw: UmpaRawEntityMetadata, value: Boolean?) = raw.setFlag(8, 1, value)

    override fun readPierceLevel(raw: UmpaRawEntityMetadata) = raw.getValue(9, Int::class.java)
    override fun writePierceLevel(raw: UmpaRawEntityMetadata, value: Int?) = raw.setValue(9, value)

}
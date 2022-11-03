package ru.melonhell.umpa.core.data.entitymeta.editor.impl.projectile

import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.projectile.UmpaArrowMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.editor.impl.abstr.UmpaAbstractArrowMetadataEditorImpl_v1_17_0
import ru.melonhell.umpa.core.utils.UmpaColor
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

@MinMaxMinecraftVersion("1.17", "latest")
open class UmpaArrowMetadataEditorImpl_v1_17_0 : UmpaArrowMetadataEditor,
    UmpaAbstractArrowMetadataEditorImpl_v1_17_0() {
    override fun readEffectColor(raw: UmpaRawEntityMetadata) = raw.getValue(10, Int::class.java)?.let {
        if (it == -1) Optional.empty() else Optional.of(
            UmpaColor(it)
        )
    }

    override fun writeEffectColor(raw: UmpaRawEntityMetadata, value: Optional<UmpaColor>?) =
        raw.setValue(10, value?.map { it.intValue }?.orElse(-1))
}
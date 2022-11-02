package ru.melonhell.umpa.bukkit.entitymeta.reader.slime

import ru.melonhell.umpa.bukkit.entitymeta.reader.mob.UmpaMobMetadataReader_v1_17_0
import ru.melonhell.umpa.bukkit.wrappers.UmpaRawEntityMetadataProtocolLib
import ru.melonhell.umpa.core.data.entitymeta.editor.readers.UmpaSlimeMetadataReader

class UmpaSlimeMetadataReader_v1_17_0(private val meta: UmpaRawEntityMetadataProtocolLib) :
    UmpaMobMetadataReader_v1_17_0(meta), UmpaSlimeMetadataReader {
    override var size: Int?
        get() = meta.getRawValue(16)
        set(value) = meta.setValue(16, value)
}
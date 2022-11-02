package ru.melonhell.umpa.bukkit.entitymeta.reader.mob

import ru.melonhell.umpa.bukkit.utils.MinMaxMinecraftVersion
import ru.melonhell.umpa.bukkit.wrappers.UmpaRawEntityMetadataProtocolLib
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMobMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.UmpaEntityMetadataReaderFactory
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
class UmpaMobMetadataReaderFactory_v1_17_0 : UmpaEntityMetadataReaderFactory {
    override fun getReader(meta: UmpaRawEntityMetadata): UmpaMobMetadataReader_v1_17_0 {
        return UmpaMobMetadataReader_v1_17_0(meta as UmpaRawEntityMetadataProtocolLib)
    }

    override val metaType: Class<out UmpaEntityMetadata>
        get() = UmpaMobMetadata::class.java
}
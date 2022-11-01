package ru.melonhell.umpa.bukkit.entitymeta.reader.slime

import ru.melonhell.umpa.bukkit.utils.MinMaxMinecraftVersion
import ru.melonhell.umpa.bukkit.wrappers.UmpaRawEntityMetadataProtocolLib
import ru.melonhell.umpa.core.data.entitymeta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.UmpaSlimeMetadata
import ru.melonhell.umpa.core.data.entitymeta.reader.UmpaEntityMetadataReaderFactory
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
class UmpaSlimeMetadataReaderFactory_v1_17_0 : UmpaEntityMetadataReaderFactory {
    override fun getReader(meta: UmpaRawEntityMetadata): UmpaSlimeMetadataReader_v1_17_0 {
        return UmpaSlimeMetadataReader_v1_17_0(meta as UmpaRawEntityMetadataProtocolLib)
    }

    override val metaType: Class<out UmpaEntityMetadata>
        get() = UmpaSlimeMetadata::class.java
}
package ru.melonhell.umpa.bukkit.entitymeta.reader.fallingBlock

import ru.melonhell.umpa.bukkit.utils.MinMaxMinecraftVersion
import ru.melonhell.umpa.bukkit.wrappers.UmpaRawEntityMetadataProtocolLib
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.other.UmpaFallingBlockMetadata
import ru.melonhell.umpa.core.data.entitymeta.reader.UmpaEntityMetadataReaderFactory
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
class UmpaFallingBlockMetadataReaderFactory_v1_17_0 : UmpaEntityMetadataReaderFactory {
    override fun getReader(meta: UmpaRawEntityMetadata): UmpaFallingBlockMetadataReader_v1_17_0 =
        UmpaFallingBlockMetadataReader_v1_17_0(meta as UmpaRawEntityMetadataProtocolLib)

    override val metaType: Class<out UmpaEntityMetadata>
        get() = UmpaFallingBlockMetadata::class.java
}
package ru.melonhell.umpa.bukkit.entitymeta.reader.armorStand

import ru.melonhell.umpa.bukkit.utils.MinMaxMinecraftVersion
import ru.melonhell.umpa.bukkit.wrappers.UmpaRawEntityMetadataProtocolLib
import ru.melonhell.umpa.core.data.entitymeta.UmpaArmorStandMetadata
import ru.melonhell.umpa.core.data.entitymeta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.reader.UmpaEntityMetadataReaderFactory
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

@MinMaxMinecraftVersion("1.17", "latest")
class UmpaArmorStandMetadataReaderFactory_v1_17_0 : UmpaEntityMetadataReaderFactory {
    override fun getReader(meta: UmpaRawEntityMetadata): UmpaArmorStandMetadataReader_v1_17_0 =
        UmpaArmorStandMetadataReader_v1_17_0(meta as UmpaRawEntityMetadataProtocolLib)

    override val metaType: Class<out UmpaEntityMetadata>
        get() = UmpaArmorStandMetadata::class.java
}
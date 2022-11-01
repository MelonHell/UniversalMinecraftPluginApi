package ru.melonhell.umpa.bukkit.entitymeta.reader.fallingBlock

import com.comphenix.protocol.wrappers.BlockPosition
import ru.melonhell.umpa.bukkit.entitymeta.reader.entity.UmpaEntityMetadataReader_v1_17_0
import ru.melonhell.umpa.bukkit.wrappers.UmpaRawEntityMetadataProtocolLib
import ru.melonhell.umpa.core.data.entitymeta.reader.readers.UmpaFallingBlockMetadataReader
import ru.melonhell.umpa.core.utils.UmpaBlockPos

class UmpaFallingBlockMetadataReader_v1_17_0(private val meta: UmpaRawEntityMetadataProtocolLib) :
    UmpaEntityMetadataReader_v1_17_0(meta), UmpaFallingBlockMetadataReader {
    override var spawnPosition: UmpaBlockPos?
        get() = meta.getRawValue<BlockPosition>(8)?.let { UmpaBlockPos(it.x, it.y, it.z) }
        set(value) = meta.setValue(8, value)
}
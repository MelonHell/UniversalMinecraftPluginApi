package ru.melonhell.umpa.core.data.entitymeta.reader.readers

import ru.melonhell.umpa.core.data.entitymeta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.UmpaFallingBlockMetadata
import ru.melonhell.umpa.core.utils.UmpaBlockPos

interface UmpaFallingBlockMetadataReader : UmpaEntityMetadataReader {
    var spawnPosition: UmpaBlockPos?

    override fun read(): UmpaFallingBlockMetadata = UmpaFallingBlockMetadata().apply { read(this) }

    override fun read(meta: UmpaEntityMetadata) {
        super.read(meta)
        if (meta !is UmpaFallingBlockMetadata) return
        spawnPosition?.let { meta.spawnPosition = it }

    }

    override fun apply(meta: UmpaEntityMetadata) {
        super.apply(meta)
        if (meta !is UmpaFallingBlockMetadata) return
        spawnPosition = meta.spawnPosition
    }
}
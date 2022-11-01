package ru.melonhell.umpa.core.data.entitymeta.reader

import ru.melonhell.umpa.core.utils.UmpaBlockPos

interface UmpaFallingBlockMetadataReader : UmpaEntityMetadataReader {
    var spawnPosition: UmpaBlockPos
}
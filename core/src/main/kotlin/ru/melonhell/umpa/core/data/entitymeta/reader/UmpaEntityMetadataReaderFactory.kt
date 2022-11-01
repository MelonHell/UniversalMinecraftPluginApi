package ru.melonhell.umpa.core.data.entitymeta.reader

import ru.melonhell.umpa.core.data.entitymeta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.reader.readers.UmpaEntityMetadataReader
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

interface UmpaEntityMetadataReaderFactory {
    fun getReader(meta: UmpaRawEntityMetadata): UmpaEntityMetadataReader
    val metaType: Class<out UmpaEntityMetadata>
}
package ru.melonhell.umpa.core.data.entitymeta.reader.readers

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.mob.UmpaSlimeMetadata

interface UmpaSlimeMetadataReader : UmpaMobMetadataReader {
    var size: Int?

    override fun read(): UmpaSlimeMetadata = UmpaSlimeMetadata().apply { read(this) }

    override fun read(meta: UmpaEntityMetadata) {
        super.read(meta)
        if (meta !is UmpaSlimeMetadata) return
        size?.let { meta.size = it }
    }

    override fun apply(meta: UmpaEntityMetadata) {
        super.apply(meta)
        if (meta !is UmpaSlimeMetadata) return
        size = meta.size
    }
}
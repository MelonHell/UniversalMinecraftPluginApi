package ru.melonhell.umpa.core.data.entitymeta.reader.readers

import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.meta.abstr.UmpaMobMetadata

interface UmpaMobMetadataReader : UmpaLivingEntityMetadataReader {
    var noAi: Boolean?
    var isLeftHanded: Boolean?
    var isAggressive: Boolean?

    override fun read(): UmpaMobMetadata = UmpaMobMetadata().apply { read(this) }

    override fun read(meta: UmpaEntityMetadata) {
        super.read(meta)
        if (meta !is UmpaMobMetadata) return
        noAi?.let { meta.noAi = it }
        isLeftHanded?.let { meta.leftHanded = it }
        isAggressive?.let { meta.aggressive = it }
    }

    override fun apply(meta: UmpaEntityMetadata) {
        super.apply(meta)
        if (meta !is UmpaMobMetadata) return
        noAi = meta.noAi
        isLeftHanded = meta.leftHanded
        isAggressive = meta.aggressive
    }
}
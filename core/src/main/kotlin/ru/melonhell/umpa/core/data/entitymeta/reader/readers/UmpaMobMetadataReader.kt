package ru.melonhell.umpa.core.data.entitymeta.reader.readers

import ru.melonhell.umpa.core.data.entitymeta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.UmpaMobMetadata

interface UmpaMobMetadataReader : UmpaLivingEntityMetadataReader {
    var noAi: Boolean?
    var isLeftHanded: Boolean?
    var isAggressive: Boolean?

    override fun read(): UmpaMobMetadata = UmpaMobMetadata().apply { read(this) }

    override fun read(meta: UmpaEntityMetadata) {
        super.read(meta)
        if (meta !is UmpaMobMetadata) return
        noAi?.let { meta.noAi = it }
        isLeftHanded?.let { meta.isLeftHanded = it }
        isAggressive?.let { meta.isAggressive = it }
    }

    override fun apply(meta: UmpaEntityMetadata) {
        super.apply(meta)
        if (meta !is UmpaMobMetadata) return
        noAi = meta.noAi
        isLeftHanded = meta.isLeftHanded
        isAggressive = meta.isAggressive
    }
}
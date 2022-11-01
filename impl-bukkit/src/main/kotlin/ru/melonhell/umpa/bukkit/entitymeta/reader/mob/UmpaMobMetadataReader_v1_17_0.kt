package ru.melonhell.umpa.bukkit.entitymeta.reader.mob

import ru.melonhell.umpa.bukkit.entitymeta.reader.livingEntity.UmpaLivingEntityMetadataReader_v1_17_0
import ru.melonhell.umpa.bukkit.wrappers.UmpaRawEntityMetadataProtocolLib
import ru.melonhell.umpa.core.data.entitymeta.reader.readers.UmpaMobMetadataReader

open class UmpaMobMetadataReader_v1_17_0(private val meta: UmpaRawEntityMetadataProtocolLib) :
    UmpaLivingEntityMetadataReader_v1_17_0(meta), UmpaMobMetadataReader {
    override var noAi: Boolean?
        get() = meta.getFlag(15, 0)
        set(value) = meta.setFlag(15, 0, value)
    override var isLeftHanded: Boolean?
        get() = meta.getFlag(15, 1)
        set(value) = meta.setFlag(15, 1, value)
    override var isAggressive: Boolean?
        get() = meta.getFlag(15, 2)
        set(value) = meta.setFlag(15, 2, value)
}
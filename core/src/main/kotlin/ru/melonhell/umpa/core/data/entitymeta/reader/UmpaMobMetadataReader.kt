package ru.melonhell.umpa.core.data.entitymeta.reader

interface UmpaMobMetadataReader : UmpaLivingEntityMetadataReader {
    var noAi: Boolean
    var isLeftHanded: Boolean
    var isAggressive: Boolean
}
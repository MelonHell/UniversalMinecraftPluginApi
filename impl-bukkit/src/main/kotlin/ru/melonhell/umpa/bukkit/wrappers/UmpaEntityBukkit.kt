package ru.melonhell.umpa.bukkit.wrappers

import com.comphenix.protocol.wrappers.WrappedDataWatcher
import org.bukkit.entity.Entity
import ru.melonhell.umpa.bukkit.entitymeta.reader.UmpaEntityMetadataReaderManagerBukkit
import ru.melonhell.umpa.bukkit.utils.converter.BukkitEnumConverter.umpa
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.enums.keyed.UmpaEntityType
import ru.melonhell.umpa.core.wrappers.UmpaEntity
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata
import java.util.*

class UmpaEntityBukkit(override val handle: Entity) : UmpaEntity() {
    override val entityId: Int
        get() = handle.entityId
    override val uuid: UUID
        get() = handle.uniqueId
    override val entityType: UmpaEntityType
        get() = handle.type.umpa()
    override val rawMeta: UmpaRawEntityMetadata
        get() = UmpaRawEntityMetadataProtocolLib(WrappedDataWatcher.getEntityWatcher(handle).asMap())

    override fun applyMeta(meta: UmpaEntityMetadata) {
        UmpaEntityMetadataReaderManagerBukkit.apply(rawMeta, meta)
    }

    override fun readMeta(meta: UmpaEntityMetadata) {
        UmpaEntityMetadataReaderManagerBukkit.collect(rawMeta, meta)
    }
}
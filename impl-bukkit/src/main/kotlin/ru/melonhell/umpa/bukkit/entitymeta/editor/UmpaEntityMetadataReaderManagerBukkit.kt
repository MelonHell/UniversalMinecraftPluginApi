package ru.melonhell.umpa.bukkit.entitymeta.editor

import ru.melonhell.umpa.bukkit.utils.MinMaxVersionUtils.isCurrentVersionInRange
import ru.melonhell.umpa.bukkit.utils.ScanUtils
import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.UmpaEntityMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.enums.keyed.UmpaEntityType
import ru.melonhell.umpa.core.wrappers.UmpaEntity
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

object UmpaEntityMetadataReaderManagerBukkit {
    private val editorMap: MutableMap<Class<out UmpaEntityMetadata>, UmpaEntityMetadataEditor> = HashMap()

    init {
        val converterClasses = ScanUtils.scanWithAnnotation(
            "ru.melonhell.umpa.core.data.entitymeta.editor.impl",
            MinMaxMinecraftVersion::class.java
        )
//        val converterClasses = KlassIndex.getAnnotated(MinMaxMinecraftVersion::class)
        converterClasses.forEach { clazz ->
            if (UmpaEntityMetadataEditor::class.java.isAssignableFrom(clazz)) {
                if (clazz.getAnnotation(MinMaxMinecraftVersion::class.java).isCurrentVersionInRange()) {
                    val readerFactory = clazz.getConstructor().newInstance() as UmpaEntityMetadataEditor
                    editorMap[readerFactory.metaType] = readerFactory
                }
            }
        }
    }

    fun createMeta(entityType: UmpaEntityType): UmpaEntityMetadata {
        return entityType.metaClass.getConstructor().newInstance() as UmpaEntityMetadata
    }

    fun getEditor(entityType: UmpaEntityType): UmpaEntityMetadataEditor {
        return getEditor(entityType.metaClass)
    }

    fun getEditor(metaClass: Class<out UmpaEntityMetadata>): UmpaEntityMetadataEditor {
        return editorMap[metaClass] ?: throw RuntimeException("editor not found")
    }

    fun collect(entity: UmpaEntity): UmpaEntityMetadata {
        val meta = entity.entityType.metaClass.getConstructor().newInstance() as UmpaEntityMetadata
        collect(entity.rawMeta, meta)
        return meta
    }

    fun collect(rawMeta: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        getEditor(meta.javaClass).readAll(rawMeta, meta)
    }

    fun apply(rawMeta: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        editorMap[meta.javaClass]?.writeAll(rawMeta, meta)
    }
}
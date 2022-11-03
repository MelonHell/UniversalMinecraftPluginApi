package ru.melonhell.umpa.bukkit.entitymeta.editor

import com.github.matfax.klassindex.KlassIndex
import ru.melonhell.umpa.bukkit.utils.MinMaxVersionUtils.isCurrentVersionInRange
import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion
import ru.melonhell.umpa.core.data.entitymeta.editor.base.UmpaEntityMetadataEditor
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

object UmpaEntityMetadataReaderManagerBukkit {
    private val readerMap: MutableMap<Class<out UmpaEntityMetadata>, UmpaEntityMetadataEditor> = HashMap()

    init {
        val converterClasses = KlassIndex.getAnnotated(MinMaxMinecraftVersion::class)
        converterClasses.forEach { clazz ->
            if (UmpaEntityMetadataEditor::class.java.isAssignableFrom(clazz.java)) {
                if (clazz.java.getAnnotation(MinMaxMinecraftVersion::class.java).isCurrentVersionInRange()) {
                    val readerFactory = clazz.java.getConstructor().newInstance() as UmpaEntityMetadataEditor
                    readerMap[readerFactory.metaType] = readerFactory
                }
            }
        }
    }

    fun collect(rawMeta: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        readerMap[meta.javaClass]?.readAll(rawMeta, meta)
    }

    fun apply(rawMeta: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        readerMap[meta.javaClass]?.writeAll(rawMeta, meta)
    }
}
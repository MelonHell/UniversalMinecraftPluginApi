package ru.melonhell.umpa.bukkit.entitymeta.reader

import com.github.matfax.klassindex.KlassIndex
import ru.melonhell.umpa.bukkit.utils.MinMaxMinecraftVersion
import ru.melonhell.umpa.bukkit.utils.MinMaxMinecraftVersion.Companion.isCurrentVersionInRange
import ru.melonhell.umpa.core.data.entitymeta.meta.UmpaEntityMetadata
import ru.melonhell.umpa.core.data.entitymeta.editor.UmpaEntityMetadataReaderFactory
import ru.melonhell.umpa.core.wrappers.UmpaRawEntityMetadata

object UmpaEntityMetadataReaderManagerBukkit {
    private val readerMap: MutableMap<Class<out UmpaEntityMetadata>, UmpaEntityMetadataReaderFactory> = HashMap()

    init {
        val converterClasses = KlassIndex.getAnnotated(MinMaxMinecraftVersion::class)
        converterClasses.forEach { clazz ->
            if (UmpaEntityMetadataReaderFactory::class.java.isAssignableFrom(clazz.java)) {
                if (clazz.java.getAnnotation(MinMaxMinecraftVersion::class.java).isCurrentVersionInRange()) {
                    val readerFactory = clazz.java.getConstructor().newInstance() as UmpaEntityMetadataReaderFactory
                    readerMap[readerFactory.metaType] = readerFactory
                }
            }
        }
    }

    fun collect(rawMeta: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        readerMap[meta.javaClass]?.getReader(rawMeta)?.read(meta) ?: throw RuntimeException()
    }

    fun apply(rawMeta: UmpaRawEntityMetadata, meta: UmpaEntityMetadata) {
        readerMap[meta.javaClass]?.getReader(rawMeta)?.apply(meta) ?: throw RuntimeException()
    }
}
package ru.melonhell.umpa.bukkit.utils

import io.github.classgraph.ClassGraph
import ru.melonhell.umpa.core.annotations.MinMaxMinecraftVersion

object ScanUtils {
    fun scan(pkg: String): Collection<Class<*>> {
        val scan = ClassGraph()
            .enableClassInfo()
            .enableAnnotationInfo()
            .acceptPackages(pkg)     // Scan com.xyz and subpackages (omit to scan all packages)
            .scan()
        return scan.getClassesWithAnnotation(MinMaxMinecraftVersion::class.java).map { it.loadClass() }
//        return Reflections(pack).getTypesAnnotatedWith(MinMaxMinecraftVersion::class.java)
//        val inputsFilter = FilterBuilder()
//        inputsFilter.includePackage(pack)
//
//        return Reflections(
//            ConfigurationBuilder()
//                .setClassLoaders(arrayOf(this::class.java.classLoader))
//                .forPackage(pack)
//                .filterInputsBy(inputsFilter)
//                .addScanners(Scanners.TypesAnnotated)
//        ).getTypesAnnotatedWith(MinMaxMinecraftVersion::class.java)
    }
}
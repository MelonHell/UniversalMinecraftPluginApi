package ru.melonhell.umpa.bukkit.utils

import io.github.classgraph.ClassGraph

object ScanUtils {
    fun scanWithAnnotation(pkg: String, annotation: Class<out Annotation>): Collection<Class<*>> {
        val scan = ClassGraph()
            .enableClassInfo()
            .enableAnnotationInfo()
            .acceptPackages(pkg)
            .scan()
        return scan.getClassesWithAnnotation(annotation).map { it.loadClass() }
    }
}
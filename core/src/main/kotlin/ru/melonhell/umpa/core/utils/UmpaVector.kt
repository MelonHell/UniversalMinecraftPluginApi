package ru.melonhell.umpa.core.utils


data class UmpaVector(
    val x: Double,
    val y: Double,
    val z: Double
) {
    constructor() : this(0.0, 0.0, 0.0)
}

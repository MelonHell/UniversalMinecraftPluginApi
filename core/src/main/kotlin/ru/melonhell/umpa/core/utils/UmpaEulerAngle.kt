package ru.melonhell.umpa.core.utils

/**
 * All values are in degrees
 */
data class UmpaEulerAngle(
    val x: Float,
    val y: Float,
    val z: Float
) {
    constructor() : this(0f, 0f, 0f)
}

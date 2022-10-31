package ru.melonhell.umpa.core.utils

data class UmpaLook(
    val yaw: Float,
    val pitch: Float
) {
    constructor() : this(0f, 0f)
}

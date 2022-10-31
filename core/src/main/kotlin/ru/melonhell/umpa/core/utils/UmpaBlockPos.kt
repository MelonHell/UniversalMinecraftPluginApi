package ru.melonhell.umpa.core.utils

data class UmpaBlockPos(
    val x: Int,
    val y: Int,
    val z: Int
) {
    constructor() : this(0, 0, 0)
}

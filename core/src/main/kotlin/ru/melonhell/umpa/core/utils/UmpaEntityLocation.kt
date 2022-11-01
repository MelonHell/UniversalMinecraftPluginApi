package ru.melonhell.umpa.core.utils

import ru.melonhell.umpa.core.wrappers.UmpaWorldWrapper

data class UmpaEntityLocation @JvmOverloads constructor(
    val world: UmpaWorldWrapper,
    val position: UmpaVector,
    val look: UmpaLook = UmpaLook()
)
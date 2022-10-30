package ru.melonhell.umpa.core.event.trait

import ru.melonhell.umpa.core.event.UmpaEvent
import ru.melonhell.umpa.core.wrappers.UmpaPlayer

interface UmpaPlayerEvent : UmpaEvent {
    val player: UmpaPlayer
}
package ru.melonhell.umpa.core.event.trait

import ru.melonhell.umpa.core.event.UmpaEvent

interface UmpaCancelableEvent : UmpaEvent {
    var canceled: Boolean
}
package ru.melonhell.umpa.core.event

import ru.melonhell.umpa.core.event.trait.UmpaCancelableEvent

class UmpaPidorEvent(
    var pidor: String,
    var value1: Int = 1,
    var value2: Int = 2,
    var value3: Int = 3,
    var res: Int = 1,
    override var canceled: Boolean = false
) : UmpaCancelableEvent
package ru.melonhell.umpa.core.event

import java.util.function.Consumer

fun interface UmpaEventConsumer<E : UmpaEvent> : Consumer<E> {
    override fun accept(event: E)

    @Suppress("UNCHECKED_CAST")
    fun acceptUnchecked(event: Any) = accept(event as E)
}
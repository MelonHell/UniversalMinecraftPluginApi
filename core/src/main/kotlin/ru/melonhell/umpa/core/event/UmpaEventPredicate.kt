package ru.melonhell.umpa.core.event

import java.util.function.Predicate

fun interface UmpaEventPredicate<E : UmpaEvent> : Predicate<E> {
    override fun test(event: E): Boolean

    @Suppress("UNCHECKED_CAST")
    fun testUnchecked(event: Any) = test(event as E)
}
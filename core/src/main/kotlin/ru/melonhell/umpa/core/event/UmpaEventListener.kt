package ru.melonhell.umpa.core.event

import ru.melonhell.umpa.core.wrappers.UmpaPluginWrapper

class UmpaEventListener<T : UmpaEvent> @JvmOverloads constructor(
    val pluginWrapper: UmpaPluginWrapper,
    val eventType: Class<T>,
    val ignoreCancelled: Boolean = true,
    var filters: List<UmpaEventPredicate<T>> = ArrayList(),
    val handler: UmpaEventConsumer<T>,
)
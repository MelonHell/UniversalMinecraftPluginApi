package ru.melonhell.umpa.core.event

import ru.melonhell.umpa.core.wrappers.PluginWrapper

class UmpaEventListener<T : UmpaEvent>(
    val pluginWrapper: PluginWrapper,
    val eventType: Class<T>,
    val ignoreCancelled: Boolean = true,
    var filters: List<UmpaEventPredicate<T>> = ArrayList(),
    val handler: UmpaEventConsumer<T>,
)
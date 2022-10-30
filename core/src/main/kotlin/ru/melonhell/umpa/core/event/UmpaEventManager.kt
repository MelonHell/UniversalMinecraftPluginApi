package ru.melonhell.umpa.core.event

import ru.melonhell.umpa.core.event.trait.UmpaCancelableEvent
import ru.melonhell.umpa.core.wrappers.PluginWrapper

class UmpaEventManager {
    private val subscribers = HashSet<UmpaEventListener<*>>()

    fun call(event: UmpaEvent) {
        for (listener in subscribers) {
            if (listener.ignoreCancelled && event is UmpaCancelableEvent && event.canceled) continue
            if (listener.filters.all { it.testUnchecked(event) }) {
                if (listener.eventType.isAssignableFrom(event.javaClass)) {
                    listener.handler.acceptUnchecked(event)
                }
            }
        }
    }

    fun call(event: UmpaCancelableEvent, successCallback: Runnable) {
        call(event)
        if (!event.canceled) successCallback.run()
    }

    fun subscribe(listener: UmpaEventListener<*>) {
        subscribers.add(listener)
    }

    fun unsubscribe(listener: UmpaEventListener<*>) {
        subscribers.remove(listener)
    }

    fun unsubscribe(pluginWrapper: PluginWrapper) {
        subscribers.removeIf { it.pluginWrapper == pluginWrapper }
    }
}
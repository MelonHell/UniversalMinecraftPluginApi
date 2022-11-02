package ru.melonhell.umpa.core.event

import org.junit.Test
import ru.melonhell.umpa.core.event.trait.UmpaCancelableEvent
import kotlin.test.assertContains
import kotlin.test.assertEquals

class EventTest {
    private val pluginWrapper = TestPluginWrapper()

    @Test
    fun mainTest() {
        val umpaEventManager = UmpaEventManager()
        umpaEventManager.subscribe(UmpaEventListener(pluginWrapper, UmpaPidorEvent::class.java, false) { event ->
            event.pidor = "new pidor"
        })


        umpaEventManager.subscribe(UmpaEventListener(pluginWrapper, UmpaSukaEvent::class.java, false) { event ->
            event.suka = "new suka"
        })


        umpaEventManager.subscribe(UmpaEventListener(pluginWrapper, UmpaCancelableEvent::class.java, false) { event ->
            event.canceled = true
        })

        val anyCallList = mutableListOf<UmpaEvent>()
        umpaEventManager.subscribe(UmpaEventListener(pluginWrapper, UmpaEvent::class.java, false) { event ->
            anyCallList.add(event)
        })


        val pidorEvent = UmpaPidorEvent("pidor value")
        umpaEventManager.call(pidorEvent)
        val sukaEvent = UmpaSukaEvent("suka value")
        umpaEventManager.call(sukaEvent)

        assertEquals(anyCallList.size, 2)
        assertContains(anyCallList, pidorEvent)
        assertContains(anyCallList, sukaEvent)
        assert(pidorEvent.canceled)
        assertEquals(pidorEvent.pidor, "new pidor")
        assertEquals(sukaEvent.suka, "new suka")
    }

    @Test
    fun filterTest() {
        val umpaEventManager = UmpaEventManager()

        umpaEventManager.subscribe(UmpaEventListener(pluginWrapper, UmpaPidorEvent::class.java, true, listOf(
            UmpaEventPredicate { event -> event.value2 == 2 },
            UmpaEventPredicate { event -> event.value1 == 1 }
        )) { event ->
            event.res += 10
        })

        umpaEventManager.subscribe(UmpaEventListener(pluginWrapper, UmpaPidorEvent::class.java, true, listOf(
            UmpaEventPredicate { event -> event.value1 == 1 },
            UmpaEventPredicate { event -> event.value3 == 5 }
        )) { event ->
            event.res += 20
        })


        val pidorEvent1 = UmpaPidorEvent("pidor value", value1 = 1, value2 = 2, value3 = 3)
        val pidorEvent2 = UmpaPidorEvent("pidor value", value1 = 1, value2 = 4, value3 = 5)
        val pidorEvent3 = UmpaPidorEvent("pidor value", value1 = 1, value2 = 2, value3 = 5)
        val pidorEvent4 = UmpaPidorEvent("pidor value", value1 = 6, value2 = 6, value3 = 6)
        umpaEventManager.call(pidorEvent1)
        umpaEventManager.call(pidorEvent2)
        umpaEventManager.call(pidorEvent3)
        umpaEventManager.call(pidorEvent4)

        assert(pidorEvent1.res == 11)
        assert(pidorEvent2.res == 21)
        assert(pidorEvent3.res == 31)
        assert(pidorEvent4.res == 1)
    }

    @Test
    fun canceledTest() {
        val umpaEventManager = UmpaEventManager()

        umpaEventManager.subscribe(UmpaEventListener(pluginWrapper, UmpaPidorEvent::class.java, true) { event ->
            event.value1 += 10
            event.canceled = true
        })

        umpaEventManager.subscribe(UmpaEventListener(pluginWrapper, UmpaPidorEvent::class.java, false) { event ->
            event.value2 += 20
            event.canceled = true
        })

        val pidorEvent = UmpaPidorEvent("pidorasina")
        umpaEventManager.call(pidorEvent)
        assert(pidorEvent.value1 == 11)
        assert(pidorEvent.value2 == 22)
        umpaEventManager.call(pidorEvent)
        assert(pidorEvent.value1 == 11)
        assert(pidorEvent.value2 == 42)
    }
}
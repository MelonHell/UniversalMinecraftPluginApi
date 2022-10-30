package ru.melonhell.umpa.core.event;

import java.util.ArrayList;

public class IdkShit {
    public void asdfasdf() {
        UmpaEventManager umpaEventManager = new UmpaEventManager();
        umpaEventManager.subscribe(new UmpaEventListener<>(UmpaPidorEvent.class, (event -> event.setPidor("123")), true, new ArrayList<>()));
    }
}

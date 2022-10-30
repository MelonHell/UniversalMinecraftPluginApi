package ru.melonhell.umpa.core;

import ru.melonhell.umpa.core.event.UmpaEventManager;
import ru.melonhell.umpa.core.managers.UmpaPacketManager;
import ru.melonhell.umpa.core.managers.UmpaPlayerManager;

public class Umpa {
    private static UmpaPlayerManager playerManager;
    private static UmpaPacketManager packetManager;

    private static UmpaEventManager eventManager;

    public static UmpaPlayerManager getPlayerManager() {
        return playerManager;
    }

    public static UmpaPacketManager getPacketManager() {
        return packetManager;
    }

    public static UmpaEventManager getEventManager() {return eventManager;}
}

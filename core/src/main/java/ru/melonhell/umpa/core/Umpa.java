package ru.melonhell.umpa.core;

import ru.melonhell.umpa.core.event.UmpaEventManager;
import ru.melonhell.umpa.core.managers.UmpaItemStackManager;
import ru.melonhell.umpa.core.managers.UmpaPacketManager;
import ru.melonhell.umpa.core.managers.UmpaPlayerManager;

public class Umpa {
    private static UmpaPlayerManager playerManager;
    private static UmpaPacketManager packetManager;
    private static UmpaEventManager eventManager;
    private static UmpaItemStackManager itemStackManager;

    public static UmpaPlayerManager getPlayerManager() {
        return playerManager;
    }

    public static UmpaPacketManager getPacketManager() {
        return packetManager;
    }

    public static UmpaEventManager getEventManager() {
        return eventManager;
    }

    public static UmpaItemStackManager getItemStackManager() {
        return itemStackManager;
    }
}

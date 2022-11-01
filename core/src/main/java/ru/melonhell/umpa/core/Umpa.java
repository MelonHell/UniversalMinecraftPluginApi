package ru.melonhell.umpa.core;

import ru.melonhell.umpa.core.event.UmpaEventManager;
import ru.melonhell.umpa.core.managers.UmpaItemStackManager;
import ru.melonhell.umpa.core.managers.UmpaPacketManager;
import ru.melonhell.umpa.core.managers.UmpaPlayerManager;

// TODO Сделать это по нормальному без жабы и рефлексии
public class Umpa {
    private static UmpaPlayerManager playerManager;
    private static UmpaPacketManager packetManager;
    private static UmpaEventManager eventManager;
    private static UmpaItemStackManager itemStackManager;

    public static UmpaPlayerManager playerManager() {
        return playerManager;
    }

    public static UmpaPacketManager packetManager() {
        return packetManager;
    }

    public static UmpaEventManager eventManager() {
        return eventManager;
    }

    public static UmpaItemStackManager itemStackManager() {
        return itemStackManager;
    }
}

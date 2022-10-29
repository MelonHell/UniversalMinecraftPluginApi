package ru.melonhell.umpa.core;

import ru.melonhell.umpa.core.managers.UmpaPacketManager;
import ru.melonhell.umpa.core.managers.UmpaPlayerManager;

public class Umpa {
    private static UmpaPlayerManager playerManager;
    private static UmpaPacketManager packetManager;

    public static UmpaPlayerManager getPlayerManager() {
        return playerManager;
    }

    public static UmpaPacketManager getPacketManager() {
        return packetManager;
    }
}

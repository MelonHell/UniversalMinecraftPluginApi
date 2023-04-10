# Archived please use [this](https://github.com/MelonHell/UniversalMinecraftApi)!

## UniversalMinecraftPluginApi (WIP)

**Русский** | [English](https://github.com/MelonHell/UniversalMinecraftPluginApi/blob/master/README_EN.md)

## О проекте

UniversalMinecraftPluginApi - это универсальное API для разработки Minecraft плагинов нацеленное как на разработку
мультиплатформенных* плагинов, так и на одну платформу.

*На данный момент имеется только реализация Bukkit

### Возможности:

- Удобная работа с пакетами без ебли с NMS или ProtocolLib
    ```java
    UmpaCbEntityAnimatePacket umpaPacket = new UmpaCbEntityAnimatePacket(
        entity.getEntityId(), 
        UmpaCbEntityAnimatePacket.EntityAnimation.SWING_MAIN_HAND
    );
    UmpaPlayer umpaPlayer = Umpa.getPlayerManager().player(player);
    Umpa.getPacketManager().send(umpaPlayer, umpaPacket);
    ```
- Универсальная Event система (которая нихуя не доделана)
- Бла-бла-бла

Крч когда я доделаю эту хуйню, можно будет писать плуги например под Bukkit и Minestom используя универсальное API

## Поддерживаемые сервера:

- [x] Bukkit
- [ ] Minestom
- [ ] Sponge
- [ ] Glowstone

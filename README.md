# UniversalMinecraftPluginApi (PacketFramework) (WIP)

Universal library for convenient work with packets

## Supported Packets And Versions

### Clientbound

| Packet \ Version | 1.8 | 1.9 | 1.10 | 1.11 | 1.12 | 1.13 | 1.14 | 1.15 | 1.16 | 1.17 | 1.18 | 1.19 |
|------------------|-----|-----|------|------|------|------|------|------|------|------|------|------|
| AddEntity        | -   | -   | -    | -    | -    | -    | -    | -    | -    | -    | -    | +    |
| GameEvent        | ?   | ?   | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | +    |
| RemoveEntities   | ?   | ?   | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | +    | 
| SetCamera        | ?   | ?   | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | +    |
| SetEquipment     | ?   | ?   | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | +    | 
| SetPassengers    | x   | ?   | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | +    | 
| TeleportEntity   | ?   | ?   | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | +    | 

### Serverbound

| Packet \ Version | 1.8 | 1.9 | 1.10 | 1.11 | 1.12 | 1.13 | 1.14 | 1.15 | 1.16 | 1.17 | 1.18 | 1.19 |
|------------------|-----|-----|------|------|------|------|------|------|------|------|------|------|
| Interact         | x   | ?   | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | +    |
| MovePlayer       | ?   | ?   | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | +    |
| PlayerInput      | ?   | ?   | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | ?    | +    |

- x - unsupported
- \? - untested
- \+ - tested

## Supported server software:

- [x] Bukkit and forks (using protocolLib)
- [ ] Bukkit and forks (without protocolLib)
- [ ] Minestom
- [ ] Sponge
- [ ] Glowstone
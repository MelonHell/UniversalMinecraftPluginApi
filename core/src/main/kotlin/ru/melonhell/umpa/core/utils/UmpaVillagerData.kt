package ru.melonhell.umpa.core.utils

class UmpaVillagerData(
    type: Type = Type.PLAINS,
    profession: Profession = Profession.NONE,
    level: Int = 1
){
    enum class Type {
        DESERT,
        JUNGLE,
        PLAINS,
        SAVANNA,
        SNOW,
        SWAMP,
        TAIGA
    }

    enum class Profession {
        NONE,
        ARMORER,
        BUTCHER,
        CARTOGRAPHER,
        CLERIC,
        FARMER,
        FISHERMAN,
        FLETCHER,
        LEATHERWORKER,
        LIBRARIAN,
        MASON,
        NITWIT,
        SHEPHERD,
        TOOLSMITH,
        WEAPONSMITH
    }
}
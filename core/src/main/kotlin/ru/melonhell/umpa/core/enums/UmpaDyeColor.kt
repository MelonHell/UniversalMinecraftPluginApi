package ru.melonhell.umpa.core.enums

enum class UmpaDyeColor(woolData: Int, dyeData: Int, color: Int, firework: Int) {
    WHITE(0x0, 0xF, 0xF9FFFE, 0xF0F0F0),
    ORANGE(0x1, 0xE, 0xF9801D, 0xEB8844),
    MAGENTA(0x2, 0xD, 0xC74EBD, 0xC354CD),
    LIGHT_BLUE(0x3, 0xC, 0x3AB3DA, 0x6689D3),
    YELLOW(0x4, 0xB, 0xFED83D, 0xDECF2A),
    LIME(0x5, 0xA, 0x80C71F, 0x41CD34),
    PINK(0x6, 0x9, 0xF38BAA, 0xD88198),
    GRAY(0x7, 0x8, 0x474F52, 0x434343),
    LIGHT_GRAY(0x8, 0x7, 0x9D9D97, 0xABABAB),
    CYAN(0x9, 0x6, 0x169C9C, 0x287697),
    PURPLE(0xA, 0x5, 0x8932B8, 0x7B2FBE),
    BLUE(0xB, 0x4, 0x3C44AA, 0x253192),
    BROWN(0xC, 0x3, 0x835432, 0x51301A),
    GREEN(0xD, 0x2, 0x5E7C16, 0x3B511A),
    RED(0xE, 0x1, 0xB02E26, 0xB3312C),
    BLACK(0xF, 0x0, 0x1D1D21, 0x1E1B1B);
}
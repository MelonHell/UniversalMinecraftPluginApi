plugins {
    id("net.minecrell.plugin-yml.bukkit") version "0.5.2"
}

bukkit {
    name = "PacketFramework"
    main = "ru.melonhell.packetframework.bukkit.PacketFrameworkBukkitPlugin"
    apiVersion = "1.13"
    authors = listOf("MelonHell")
    depend = listOf("ProtocolLib")
    libraries = listOf(
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.20",
        "net.kyori:adventure-api:4.11.0",
        "net.kyori:adventure-platform-bukkit:4.1.2"
    )
}

dependencies {
    compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
    compileOnly("net.kyori:adventure-platform-bukkit:4.1.2")
    compileOnly("com.comphenix.protocol:ProtocolLib:5.0.0-SNAPSHOT")
    implementation("com.github.matfax.klassindex:library:4.1.0-rc.1")
    kapt("com.github.matfax.klassindex:processor:4.1.0-rc.1")
}
plugins {
    id("net.minecrell.plugin-yml.bukkit") version "0.5.2"
}

bukkit {
    name = "PacketFramework"
    main = "ru.melonhell.packetframework.bukkit.PacketFrameworkBukkitPlugin"
    apiVersion = "1.13"
    authors = listOf("MelonHell")
    depend = listOf("ProtocolLib")
    libraries = listOf("net.kyori:adventure-platform-bukkit:4.1.2")
}

dependencies {
    compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
//    compileOnly("org.spigotmc:spigot-api:1.16.5-R0.1-SNAPSHOT")
    compileOnly("net.kyori:adventure-platform-bukkit:4.1.2")
    compileOnly("com.comphenix.protocol:ProtocolLib:5.0.0-SNAPSHOT")
    implementation("org.reflections:reflections:0.10.2")
}
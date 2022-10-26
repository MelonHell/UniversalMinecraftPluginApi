plugins {
    id("net.minecrell.plugin-yml.bukkit") version "0.5.2"
}

bukkit {
    name = "PacketFramework"
    main = "ru.melonhell.packetframework.bukkit.PacketFrameworkBukkitPlugin"
    apiVersion = "1.13"
    authors = listOf("MelonHell")
    depend = listOf("ProtocolLib")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")
    compileOnly("com.comphenix.protocol:ProtocolLib:5.0.0-SNAPSHOT")
    implementation("org.reflections:reflections:0.10.2")
}
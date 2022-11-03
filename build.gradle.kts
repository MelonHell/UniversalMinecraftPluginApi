import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    kotlin("jvm") version "1.7.20"
    kotlin("kapt") version "1.7.20"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "ru.melonhell"

val basePackage = "${group}.umpa"

allprojects {
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-kapt")
    apply(plugin = "java-library")
    version = "1.0-SNAPSHOT"

    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") // Spigot API
//        maven("https://papermc.io/repo/repository/maven-public/") // Paper API
        maven("https://repo.dmulloy2.net/repository/public/") // ProtocolLib
    }
    dependencies {
        compileOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.20")
        compileOnly("net.kyori:adventure-api:4.11.0")

        implementation("com.github.matfax.klassindex:library:4.1.0-rc.1")
        kapt("com.github.matfax.klassindex:processor:4.1.0-rc.1")

        testImplementation(kotlin("test"))
    }
    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
                freeCompilerArgs = listOf("-Xjvm-default=all")
            }
        }
    }
}

subprojects.forEach {
    dependencies.api(it)
}

configure(allprojects - project(":core")) {
    dependencies.api(project(":core"))
}

tasks {
    shadowJar {
        archiveVersion.set("")
        archiveClassifier.set("")
        relocate("com.github.matfax.klassindex", "${basePackage}.libs.klassindex")
    }
    jar {
        enabled = false
    }
    assemble {
        dependsOn(shadowJar)
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
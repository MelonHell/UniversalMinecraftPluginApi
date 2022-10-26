import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "ru.melonhell"

val basePackage = "${group}.packetframework"

allprojects {
    apply(plugin = "kotlin")
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
        maven("https://papermc.io/repo/repository/maven-public/") // PaperAPI
        maven("https://repo.dmulloy2.net/repository/public/") // ProtocolLib
    }
    dependencies {
        implementation("org.greenrobot:eventbus-java:3.3.1")
    }
}

dependencies {
    implementation("org.greenrobot:eventbus-java:3.3.1")
    testImplementation(kotlin("test"))
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

        relocate("org.greenrobot.eventbus", "${basePackage}.libs.eventbus")

        relocate("org.reflections", "${basePackage}.libs.reflections")
        relocate("javassist", "${basePackage}.libs.javassist")
        relocate("javax", "${basePackage}.libs.javax")
        relocate("org.slf4j", "${basePackage}.libs.slf4j")

        relocate("kotlin", "${basePackage}.libs.kotlin")
        relocate("org.intellij", "${basePackage}.libs.intellij")
        relocate("org.jetbrains", "${basePackage}.libs.jetbrains")
    }
    jar {
        enabled = false;
    }
    assemble {
        dependsOn(shadowJar)
    }
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
    withType<GenerateModuleMetadata> {
        enabled = false
    }
}
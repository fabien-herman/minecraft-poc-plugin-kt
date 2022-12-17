plugins {
    id("java")
    kotlin("jvm") version "1.7.22"
}

// Update to your project
group = "your.namespace.poc"
version = "1.0.0"

repositories {
    mavenCentral()
    maven {
        name = "papermc-repo"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        name = "spigot-repo"
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }
    maven {
        name = "sonatype"
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks {
    // This will ensure all releases will target java 17
    compileJava {
        options.release.set(JavaVersion.VERSION_17.ordinal + 1)
    }
    // This will update the plugin.yml with version value
    processResources {
        mapOf("version" to version)
            .let {
                inputs.properties(it)
                filteringCharset = "UTF-8"
                filesMatching("plugin.yml") { expand(it) }
            }
    }
    // this will add the kotlin libraries to the final jar
    jar {
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        sourceSets.main.get().output + configurations.runtimeClasspath.get()
            .map { if (it.isDirectory) it else zipTree(it) }
            .let { from(it) }
    }
}

dependencies {
    // Libraries that will be included in released plugin jar
    val kotlinxCoroutinesVersion = "1.6.4"
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$kotlinxCoroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:$kotlinxCoroutinesVersion")

    // Library provided by the minecraft server
    compileOnly("io.papermc.paper:paper-api:1.19.2-R0.1-SNAPSHOT")
    compileOnly("org.spigotmc:spigot-api:1.19.2-R0.1-SNAPSHOT")
}

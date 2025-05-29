plugins {
    kotlin("jvm") version "2.1.20"
}

group = "org.trex.kotlin"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
}

tasks.test {
    useJUnitPlatform()
}


kotlin {
    jvmToolchain(11)
}
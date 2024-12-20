plugins {
    kotlin("jvm") version "2.0.21"
}

group = "org.hyunjung"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("junit:junit:4.13.2")
}

kotlin {
    jvmToolchain(17)
}
plugins {
    kotlin("jvm") version "2.1.0"
    kotlin("plugin.serialization") version "2.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("junit:junit:4.13.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.1")
    implementation("org.slf4j:slf4j-simple:2.0.9")
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.1")

    val ktor_version = "3.0.3"
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    testImplementation("io.ktor:ktor-client-mock:$ktor_version")
    
}

tasks.test {
    useJUnitPlatform()

}
kotlin {
    jvmToolchain(17)
}
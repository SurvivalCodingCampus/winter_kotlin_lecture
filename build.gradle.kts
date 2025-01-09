plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.serialization") version "2.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val ktor_version = "3.0.3"

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("junit:junit:4.13.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
    implementation("io.socket:socket.io-client:2.0.1") // 최신 버전 확인 필요
    implementation("com.google.code.gson:gson:2.8.9")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.1")
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("org.slf4j:slf4j-nop:2.0.7")
    testImplementation("io.ktor:ktor-client-mock:$ktor_version")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
plugins {
    java
    buildSrcVersions
    kotlin("jvm") version Versions.org_jetbrains_kotlin
}

group = "ru.volggtu"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    //koltin
    implementation(Libs.kotlin_stdlib_jdk8)

    //json
    implementation(Libs.json)

    //logger
    implementation(Libs.log4j_api_kotlin)
    implementation(Libs.log4j_core)

    //test dependencies
    testImplementation(Libs.junit_jupiter_engine)
    testImplementation(Libs.mockk)
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }

    wrapper {
        gradleVersion = Versions.gradleLatestVersion
    }
}
plugins {
    buildSrcVersions
    kotlin("jvm") version Versions.org_jetbrains_kotlin
}

group = "ru.volggtu"
version = "0.3.0"

repositories {
    jcenter()
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

    //AI
    //compileOnly("nz.ac.waikato.cms.weka:weka-stable:3.8.4")
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }

    wrapper {
        gradleVersion = Versions.gradleLatestVersion
    }

    jar {
        manifest {
            attributes(mapOf("Implementation-Title" to project.name, "Implementation-Version" to project.version))
        }
    }
}
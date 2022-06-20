rootProject.name = "updateoperators-demo"

dependencyResolutionManagement {
    versionCatalogs {
        create("tools") {
            version("kotlin", "1.6.21")
            version("jvm", "17")

            plugin("kotlin-lang", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
            plugin("kotlin-allopen", "org.jetbrains.kotlin.plugin.allopen").versionRef("kotlin")
            plugin("kotlin-spring", "org.jetbrains.kotlin.plugin.spring").versionRef("kotlin")

            library("kotlin-reflect", "org.jetbrains.kotlin", "kotlin-reflect").versionRef("kotlin")
            library("kotlin-stdlib", "org.jetbrains.kotlin", "kotlin-stdlib-jdk8").versionRef("kotlin")
        }

        create("libs") {
            plugin("spring.boot", "org.springframework.boot").version("2.7.0")
            plugin("spring.dependencymanagement", "io.spring.dependency-management").version("1.0.11.RELEASE")
            library("kotlinlogging", "io.github.microutils:kotlin-logging-jvm:2.1.20")

            library("kotest.core", "io.kotest:kotest-runner-junit5:5.3.1")
            library("kotest.assertions.core", "io.kotest:kotest-assertions-core:5.3.1")
            library("kotest.extensions.spring", "io.kotest.extensions:kotest-extensions-spring:1.1.1")
            library("kotest.extensions.testcontainers", "io.kotest.extensions:kotest-extensions-testcontainers:1.3.3")
            library("testcontainers-mongodb", "org.testcontainers:mongodb:1.17.2")
        }
    }
}
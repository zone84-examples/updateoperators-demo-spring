import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION") // workaround for IntelliJ bug with Gradle Version Catalogs DSL in plugins
plugins {
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.spring.dependencymanagement)
	alias(tools.plugins.kotlin.lang)
	alias(tools.plugins.kotlin.spring)
	alias(tools.plugins.kotlin.allopen)
}

group = "tech.zone84.updateoperators"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.toVersion(tools.versions.jvm.get())

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation(libs.kotlinlogging)
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation(libs.kotest.core)
	testImplementation(libs.kotest.assertions.core)
	testImplementation(libs.kotest.extensions.spring)
	testImplementation(libs.kotest.extensions.testcontainers)
	testImplementation(libs.testcontainers.mongodb)
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = tools.versions.jvm.get()
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

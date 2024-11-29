plugins {
	java
	id("org.springframework.boot") version "3.4.0"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "dev.a13i"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web:3.4.0")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.4.0")
	implementation("com.h2database:h2:2.3.232")
	testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.0")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.11.3")
	developmentOnly("org.springframework.boot:spring-boot-devtools:3.4.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
